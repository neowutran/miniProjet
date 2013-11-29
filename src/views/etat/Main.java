
package views.etat;

import java.util.List;

import model.Finder;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;

import views.State;
import views.View;

/**
 * The Class Main.
 */
public class Main extends State {

    /*
     * (non-Javadoc)
     *
     * @see views.IView#action(org.apache.commons.cli.CommandLine)
     */
    @Override
    public void action( final CommandLine line ) {

        if( line.hasOption( "help" ) ) {
            this.printHelp( );
        } else if( line.hasOption( "exit" ) ) {
            this.exit( );
        } else if( "login".equals( line.getArgList( ).get( 0 ) ) ) {
            this.login( line.getArgList( ) );

        }

    }

    /**
     * Login.
     *
     * @param args
     *            the args
     */
    private void login( final List<String> args ) {
        if( args.size( ) != 3 ) {

            System.out
                    .println( "L'utilisation de cette commande est: login <id> <password>" );

        } else {

            final String id = args.get( 1 );
            final String password = args.get( 2 );

            if( model.User.getInstance( ).login( id, password ) ) {

                System.out.println( "Welcome "
                        + Finder.findPersonById( id ).getName( ) );
                if( Finder.isBorrower( id ) ) {
                    View.setState( new Borrower( ) );
                } else {
                    View.setState( new Administrator( ) );
                }

            } else {

                System.out.println( "Mauvais utilisateur ou mot de passe" );

            }

        }
    }

    /*
     * (non-Javadoc)
     *
     * @see views.IView#setOptions()
     */
    @Override
    public Options setOptions( ) {

        final Options options = new Options( );
        options.addOption( OptionBuilder.withLongOpt( "exit" ).create( ) );
        options.addOption( OptionBuilder.withArgName( "login" ).hasArgs( 2 )
                .withValueSeparator( ).withDescription( "login" )
                .create( "login" ) );
        final Option help = new Option( "help", "help" );
        options.addOption( help );
        return options;
    }
}
