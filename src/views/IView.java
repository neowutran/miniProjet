
package views;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

/**
 * The Interface IView.
 */
public interface IView {

    /**
     * Action.
     *
     * @param line
     *            the line
     */
    void action( CommandLine line );

    /**
     * Sets the options.
     *
     * @return the options
     */
    Options setOptions( );
}
