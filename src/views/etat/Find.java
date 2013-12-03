
package views.etat;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import views.Command;
import views.State;

/**
 * The Class Find.
 */

public class Find extends State {

    /** The features. */
    private final List<String> features  = new LinkedList<>( );

    /** The operators. */
    private final List<String> operators = new LinkedList<>( );

    /** The values. */
    private final List<String> values    = new LinkedList<>( );

    /** The start. */
    private final Calendar     start     = Calendar.getInstance( );

    /** The end. */
    private final Calendar     end       = Calendar.getInstance( );

    /**
     * Adds the.
     *
     * @param line the line
     */
 

    /*
     * (non-Javadoc)
     *
     * @see views.IView#setCommands()
     */
    @Override
    public List<Command> setCommands() {

        return null;
        /*
         * final Options options = new Options();
         *
         * options.addOption(OptionBuilder.withArgName("add").hasArgs(3).
         * withValueSeparator().withDescription("add").create("add"));
         *
         * options.addOption(OptionBuilder.withArgName("type").hasArgs(1).
         * withValueSeparator().withDescription("type").create("type"));
         *
         * options.addOption(OptionBuilder.withArgName("start").hasArgs(2).
         * withValueSeparator().withDescription("start").create("start"));
         *
         * options.addOption(OptionBuilder.withArgName("end").hasArgs(2).
         * withValueSeparator().withDescription("end").create("end"));
         *
         * options.addOption(OptionBuilder.withArgName("find").hasArgs(0).
         * withValueSeparator().withDescription("find").create("find"));
         *
         * options.addOption(OptionBuilder.withArgName("cancel").hasArgs(0).
         * withValueSeparator().withDescription("cancel").create("cancel"));
         *
         * options.addOption(OptionBuilder.withArgName("exit").hasArgs(0).
         * withValueSeparator().withDescription("exit").create("exit"));
         *
         * return options;
         */
    }

}
