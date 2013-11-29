
package views.etat;

import java.util.Collection;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;

import views.State;
import views.View;

/**
 * The Class Borrower.
 */
public class Borrower extends State {

    /* (non-Javadoc)
     * @see views.IView#action(org.apache.commons.cli.CommandLine)
     */
    @Override
    public void action( final CommandLine line ) {

        final boolean action = User.action( line );
        if( action ) {
            return;
        }

        if( !line.getArgList( ).isEmpty( )
                && "borrow".equals( line.getArgList( ).get( 0 ) ) ) {
            View.setState( new Borrow( ) );
        } else if( line.hasOption( "help" ) ) {
            this.printHelp( );
        }

    }

    /* (non-Javadoc)
     * @see views.IView#setOptions()
     */
    @Override
    public Options setOptions( ) {

        final Options options = new Options( );
        options.addOption( OptionBuilder.withArgName( "borrow" ).hasArgs( )
                .withValueSeparator( ).withDescription( "borrow" )
                .create( "borrow" ) );

        final Options userOptions = User.setOptions( );
        for( final Option o : ( Collection<Option> ) userOptions.getOptions( ) ) {
            options.addOption( o );
        }

        return options;
    }
}
