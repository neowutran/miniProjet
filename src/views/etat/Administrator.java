
package views.etat;

import java.util.Collection;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import views.State;

/**
 * The Class Administrator.
 */
public class Administrator extends State {

    /* (non-Javadoc)
     * @see views.IView#action(org.apache.commons.cli.CommandLine)
     */
    @Override
    public void action( final CommandLine line ) {

        if( line.hasOption( "help" ) ) {
            this.printHelp( );
        }
    }

    /* (non-Javadoc)
     * @see views.IView#setOptions()
     */
    @Override
    public Options setOptions( ) {

        final Options options = new Options( );

        final Options userOptions = User.setOptions( );
        for( final Option o : ( Collection<Option> ) userOptions.getOptions( ) ) {
            options.addOption( o );
        }

        return options;
    }
}
