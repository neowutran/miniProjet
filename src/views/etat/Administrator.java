package views.etat;

import model.*;
import model.State;
import org.apache.commons.cli.*;
import views.*;

import java.lang.reflect.*;
import java.util.*;

/**
 * The Class Administrator.
 */
public class Administrator extends User {


    private void findLateBorrow(){
        System.out.println(Finder.findLateBorrow());

    }

    private void findBorrowWaitingForAdministrator(){
        System.out.println(Finder.findBorrowWaitingForAdministrator());
    }

    private void findBorrowById(String id){

            System.out.println(Finder.findBorrowByBorrower(id));

    }

    private void findBorrowByBorrower(String id){

            System.out.println(Finder.findBorrowByBorrower(id));

    }

    private void findActualBorrowByBorrower(String id){

            System.out.println(Finder.findActualBorrowByBorrower(id));

    }
    private void returned(String id) {

        model.person.Borrower.Borrow borrow = Finder.findBorrowById(id);
        if (borrow == null) {
            this.printHelp();
            return;
        }
        ((model.person.Administrator) Finder.findPersonById(model.User.getInstance().getPersonneId())).setBorrowStat(borrow, model.State.RETURNED);
        System.out.println("Borrow returned");

    }

    private void accept(String id) {


        model.person.Borrower.Borrow borrow = Finder.findBorrowById(id);
        if (borrow == null) {
            this.printHelp();
            return;
        }
        if (((model.person.Administrator) Finder.findPersonById(model.User.getInstance().getPersonneId())).setBorrowStat(borrow, model.State.ACCEPT)) {
            System.out.println("Borrow accepted");
        } else {
            System.out.println("Error, the borrow cannot be accepted");
        }
    }

    private void refuse(String id) {

        model.person.Borrower.Borrow borrow = Finder.findBorrowById(id);
        if (borrow == null) {
            this.printHelp();
            return;
        }
        ((model.person.Administrator) Finder.findPersonById(model.User.getInstance().getPersonneId())).setBorrowStat(borrow, model.State.REFUSE);
        System.out.println("Borrow refused");

    }

    /*
     * (non-Javadoc)
     *
     * @see views.IView#defineOptions()
     */
    @Override
    public List<Command> defineOptions() {

        final List<Command> commands = new ArrayList<>();

        Command command1 = new Command("findLateBorrow", new LinkedList<String>(), this, "findLateBorrow", "descriptionHere");
        Command command2 = new Command("findBorrowWaitingForAdministrator", new LinkedList<String>(), this, "findBorrowWaitingForAdministrator", "descriptionHere");

        List<String> args3 = new LinkedList<>();
        args3.add("borrowId");
        Command command3 = new Command("findBorrowById", args3, this, "findBorrowById", "descriptionHere");

        List<String> args4 = new LinkedList<>();
        args4.add("borrowerId");
        Command command4 = new Command("findActualBorrowByBorrower", args4, this, "findActualBorrowByBorrower", "descriptionHere");

        List<String> args5 = new LinkedList<>();
        args5.add("borrowId");
        Command command5 = new Command("accept", args5, this, "accept", "descriptionHere");

        Command command6 = new Command("refuse", args5, this, "refuse", "descriptionHere");
        Command command7 = new Command("return", args5, this, "return", "descriptionHere");


        commands.add(command1);
        commands.add(command2);
        commands.add(command3);
        commands.add(command4);
        commands.add(command5);
        commands.add(command6);
        commands.add(command7);
        commands.addAll(super.defineOptions());

        return commands;

    }
}
