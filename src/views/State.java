
package views;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.MiniProjectException;
import model.SaveLoad;

// TODO: Auto-generated Javadoc
/**
 * The Class State.
 */
public abstract class State implements IView {

    /*
     * (non-Javadoc)
     *
     * @see views.IView#action(org.apache.commons.cli.CommandLine)
     */
    // @Override
    /**
     * Action.
     *
     * @param line the line
     */
    public void action( final String[ ] line ) {

        if( line == null || line.length == 0 ) {
            return;
        }
        for( final Command command : this.defineOptions( ) ) {

            if( command.getName( ).equals( line[ 0 ] ) ) {

                try {
                    command.invoke( line );
                } catch( final MiniProjectException e ) {
                    e.printStackTrace( );
                }

                return;
            }

        }

        if( !line[ 0 ].equals( "" ) ) {
            this.printHelp( );
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see views.IView#defineOptions()
     */
    @Override
    public List<Command> defineOptions( ) {

        final List<Command> commands = new ArrayList<>( );

        final Command command1 = new Command( "exit",
                new LinkedList<String>( ), this, "exit", "descriptionHere" );
        final Command command2 = new Command( "help",
                new LinkedList<String>( ), this, "printHelp", "descriptionHere" );

        commands.add( command1 );
        commands.add( command2 );

        return commands;

    }

    /**
     * Exit.
     */
    public void exit( ) {

        SaveLoad.save( );
        System.exit( 0 );
    }

    /**
     * Interpreter.
     *
     * @param line the line
     */
    public void interpreter( final String line ) {

        this.action( line.split( " " ) );

    }

    /**
     * Prints the help.
     */
    public void printHelp( ) {

        System.out.println( "===== HELP ======\n" );
        for( final Command command : this.defineOptions( ) ) {
            System.out.println( command );
        }
        System.out.println( "=================\n" );
    }

}
