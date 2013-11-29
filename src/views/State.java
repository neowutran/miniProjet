
package views;

import model.SaveLoad;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import controllers.MiniProjectController;

/**
 * The Class State.
 */
public abstract class State implements IView {

    /** The options. */
    private Options options = this.setOptions( );

    /**
     * Exit.
     */
    public void exit( ) {
        SaveLoad.save( );
        System.exit( 0 );
    }

    /**
     * Gets the options.
     *
     * @return the options
     */
    protected Options getOptions( ) {

        return this.options;
    }

    /**
     * Intepreter.
     *
     * @param line the line
     */
    public void interpreter(final String line) {

        final CommandLineParser cmdLineParser = new GnuParser( );

        try {

            final CommandLine cmdLine = cmdLineParser.parse( this.options,
                    line.split( " " ) );
            this.action( cmdLine );

        } catch( final ParseException e ) {
            MiniProjectController.LOGGER.severe( java.util.Arrays.toString( e
                    .getStackTrace( ) ) );

        }

    }

    /**
     * Prints the help.
     */
    public void printHelp( ) {
        final HelpFormatter f = new HelpFormatter( );
        f.printHelp( "Help", this.getOptions( ) );
    }

    /**
     * Sets the options.
     *
     * @param options the new options
     */
    protected void setOptions( final Options options ) {

        this.options = options;
    }

}
