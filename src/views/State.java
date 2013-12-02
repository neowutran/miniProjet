package views;

import model.*;

import java.util.*;

/**
 * The Class State.
 */
public abstract class State implements IView {

    /**
     * Exit.
     */
    public void exit() {

        SaveLoad.save();
        System.exit(0);
    }

    /*
    * (non-Javadoc)
    *
    * @see views.IView#action(org.apache.commons.cli.CommandLine)
    */
    // @Override
    public void action(final String[] line) {

        if (line == null || line.length == 0) {
            return;
        }
        for (Command command : this.defineOptions()) {

            if (command.getName().equals(line[0])) {

                try {
                    command.invoke(line);
                    return;
                } catch (MiniProjectException e) {
                    e.printStackTrace();
                }

            }

        }

        if (!line[0].equals("")) {
            this.printHelp();
        }

    }

    /*
 * (non-Javadoc)
 *
 * @see views.IView#defineOptions()
 */
    @Override
    public List<Command> defineOptions() {

        List<Command> commands = new ArrayList<>();

        Command command1 = new Command("exit", new LinkedList<String>(), this, "exit", "descriptionHere");
        Command command2 = new Command("help", new LinkedList<String>(), this, "printHelp", "descriptionHere");

        commands.add(command1);
        commands.add(command2);

        return commands;

    }

    /**
     * Intepreter.
     *
     * @param line the line
     */
    public void interpreter(final String line) {

        this.action(line.split(" "));

    }

    /**
     * Prints the help.
     */
    public void printHelp() {

        System.out.println("===== HELP ======\n");
        for (Command command : this.defineOptions()) {
            System.out.println(command);
        }
        System.out.println("=================\n");
    }

}
