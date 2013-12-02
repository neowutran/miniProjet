package views.etat;

import model.*;
import org.apache.commons.cli.*;
import views.*;
import views.State;

import java.util.*;

/**
 * The Class Main.
 */
public class Main extends State {

     /**
     * Login.
     *
     * @param args the args
     */
    private void login(String id, String password) {

        if (model.User.getInstance().login(id, password)) {

            System.out.println("Welcome " + Finder.findPersonById(id).getName());
            if (Finder.isBorrower(id)) {
                View.setState(new Borrower());
            } else {
                View.setState(new Administrator());
            }

        } else {

            System.out.println("Mauvais utilisateur ou mot de passe");

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

        List<String> args1 = new LinkedList<>();
        args1.add("id");
        args1.add("password");
        Command command1 = new Command("login", args1, this, "login", "descriptionHere");

        commands.add(command1);
        commands.addAll(super.defineOptions());

        return commands;

    }
}
