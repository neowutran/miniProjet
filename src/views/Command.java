
package views;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import lib.ArrayUtils;
import model.MiniProjectException;

import com.sun.istack.internal.NotNull;

// TODO: Auto-generated Javadoc
/**
 * The Class Command.
 */
public class Command {

    /** The name. */
    private final String name;

    /** The args. */
    private List<String> args = new LinkedList<>( );

    /** The description. */
    private final String description;

    /** The state. */
    private final State  state;

    /** The method. */
    private final String method;

    /**
     * Instantiates a new command.
     *
     * @param name the name
     * @param args the args
     * @param state the state
     * @param method the method
     * @param description the description
     */
    public Command( @NotNull final String name,
            @NotNull final List<String> args, @NotNull final State state,
            @NotNull final String method, @NotNull final String description ) {

        this.name = name;
        this.args = args;
        this.state = state;
        this.method = method;
        this.description = description;

    }

    /**
     * Gets the args.
     *
     * @return the args
     */
    public List<String> getArgs( ) {

        return this.args;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName( ) {

        return this.name;
    }

    /**
     * Invoke.
     *
     * @param arg the arg
     * @throws MiniProjectException the mini project exception
     */
    public void invoke( final String[ ] arg ) throws MiniProjectException {

        if( arg.length - 1 != this.args.size( ) ) {

            this.state.printHelp( );
            return;
        }

        final Method[ ] methods = ArrayUtils.concatenate( this.state.getClass( )
                .getDeclaredMethods( ), this.state.getClass( ).getMethods( ) );


        for( final Method method : methods ) {

            if( !method.getName( ).equals( this.method ) ) {
                continue;
            }

            final Class[ ] parameters = method.getParameterTypes( );
            if( parameters.length != this.args.size( ) ) {
                continue;
            }

            Boolean goodMethod = true;

            for( final Class parameter : parameters ) {

                if( !parameter.equals( String.class ) ) {
                    goodMethod = false;
                    break;
                }
            }

            if( goodMethod ) {

                method.setAccessible( true );
                try {
                    method.invoke( this.state,
                            Arrays.copyOfRange( arg, 1, arg.length ) );
                } catch( IllegalAccessException | InvocationTargetException e ) {
                    e.printStackTrace( );
                }
                return;
            }
        }

        throw new MiniProjectException( "method not found" );

    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString( ) {

        String show = "- " + this.name + " : " + this.name;
        for( final String arg : this.args ) {
            show += " " + arg;
        }
        show += "\n";
        show += "\t" + this.description + "\n";

        return show;
    }
}
