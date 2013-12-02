
package views;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import java.util.*;

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
  //  void action( String[] line );

    /**
     * Sets the options.
     *
     * @return the options
     */
    List<Command> defineOptions();
}
