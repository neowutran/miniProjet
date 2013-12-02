
package views.etat;

import java.util.*;

import model.*;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;

import views.*;

/**
 * The Class Borrower.
 */
public class Borrower extends User {

    /*
     * (non-Javadoc)
     *
     * @see views.IView#defineOptions()
     */
    @Override
    public List<Command> defineOptions() {

        List<Command> commands = new ArrayList<>();

        Command command1 = new Command("borrow", new LinkedList<String>(), this, "borrow", "descriptionHere");
        commands.add(command1);
        commands.addAll(super.defineOptions());

        return commands;

    }

    private void borrow(){
        View.setState(new Borrow());
    }
}
