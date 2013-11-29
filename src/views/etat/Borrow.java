
package views.etat;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import views.State;

/**
 * The Class Borrow.
 */
public class Borrow extends State {

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

        return null;
    }
}
