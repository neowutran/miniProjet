
package views.etat;

import model.*;
import model.User;
import org.apache.commons.cli.*;

import views.*;
import views.State;

import java.util.*;

/**
 * The Class Find.
 */

public class Find extends State {

    private List<String> features = new LinkedList<>();
    private List<String> operators = new LinkedList<>();
    private List<String> values = new LinkedList<>();
    private Calendar start = Calendar.getInstance();
    private Calendar end = Calendar.getInstance();

    private void add(CommandLine line){

    }


    private void setEnd(CommandLine line){
        if (line.getArgList().size() != 3) {
            this.printHelp();
        } else {
            String[] dayMonthYear = ((String) line.getArgList().get(1)).split("/");
            String[] hourMinute = ((String) line.getArgList().get(2)).split(":");
            if(dayMonthYear.length != 3 || hourMinute.length != 2){
                this.printHelp();
            }

            this.end.set(Integer.valueOf(dayMonthYear[2]), Integer.valueOf(dayMonthYear[1]), Integer.valueOf(dayMonthYear[0]), Integer.valueOf(hourMinute[0]), Integer.valueOf(hourMinute[1]), 0);

            System.out.println("end date set");
        }

    }

    private void setStart(CommandLine line){
        if (line.getArgList().size() != 3) {
            this.printHelp();
        } else {
            String[] dayMonthYear = ((String) line.getArgList().get(1)).split("/");
            String[] hourMinute = ((String) line.getArgList().get(2)).split(":");
            if(dayMonthYear.length != 3 || hourMinute.length != 2){
                this.printHelp();
            }
            this.start.set(Integer.valueOf(dayMonthYear[2]), Integer.valueOf(dayMonthYear[1]), Integer.valueOf(dayMonthYear[0]), Integer.valueOf(hourMinute[0]), Integer.valueOf(hourMinute[1]), 0);

            System.out.println("Start date set");
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see views.IView#defineOptions()
     */
    @Override
    public List<Command> defineOptions() {

        return null;
        /*
        final Options options = new Options();

        options.addOption(OptionBuilder.withArgName("add").hasArgs(3).withValueSeparator().withDescription("add").create("add"));

        options.addOption(OptionBuilder.withArgName("type").hasArgs(1).withValueSeparator().withDescription("type").create("type"));

        options.addOption(OptionBuilder.withArgName("start").hasArgs(2).withValueSeparator().withDescription("start").create("start"));

        options.addOption(OptionBuilder.withArgName("end").hasArgs(2).withValueSeparator().withDescription("end").create("end"));

        options.addOption(OptionBuilder.withArgName("find").hasArgs(0).withValueSeparator().withDescription("find").create("find"));

        options.addOption(OptionBuilder.withArgName("cancel").hasArgs(0).withValueSeparator().withDescription("cancel").create("cancel"));

        options.addOption(OptionBuilder.withArgName("exit").hasArgs(0).withValueSeparator().withDescription("exit").create("exit"));

        return options;
*/
    }
}
