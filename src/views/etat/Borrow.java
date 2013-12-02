
package views.etat;

import model.*;
import model.User;
import org.apache.commons.cli.*;

import views.*;
import views.State;

import java.text.*;
import java.util.*;

/**
 * The Class Borrow.
 */
public class Borrow extends State {


    private List<String> equipments = new ArrayList<>();
    private Calendar start = Calendar.getInstance();
    private Calendar end = Calendar.getInstance();

    private void cancel(){
        View.setState(new Borrower());
    }

    private void show(){
        final SimpleDateFormat format = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm" );
        String show = "equipment:"+this.equipments+"\n"+
                      "start:"+format.format(this.start.getTime())+"\n"+
                      "end:"+format.format(this.end.getTime());
        System.out.println(show);


    }

    private void remove(String id){

            equipments.remove(id);
            System.out.println("Equipment "+id+" removed");

    }

    private void add(String id){
            equipments.add(id);
            System.out.println("Equipment "+id+" added");

    }

    private void validate(){
        if(Finder.isBorrowed(equipments, start,end)){
            System.out.println("Equipment unavailable");
            return;
        }

        ((model.person.Borrower)Finder.findPersonById(User.getInstance().getPersonneId())).borrow(equipments, start, end);
        System.out.println("Borrowed.");
    }

    private void setEnd(String stringDayMonthYear, String stringHourMinute){

            String[] dayMonthYear = stringDayMonthYear.split("/");
            String[] hourMinute = stringHourMinute.split(":");
            if(dayMonthYear.length != 3 || hourMinute.length != 2){
                this.printHelp();
            }

            this.end.set(Integer.valueOf(dayMonthYear[2]), Integer.valueOf(dayMonthYear[1]), Integer.valueOf(dayMonthYear[0]), Integer.valueOf(hourMinute[0]), Integer.valueOf(hourMinute[1]), 0);

            System.out.println("end date set");


    }

    private void setStart(String stringDayMonthYear, String stringHourMinute){

            String[] dayMonthYear = stringDayMonthYear.split("/");
            String[] hourMinute = stringHourMinute.split(":");
            if(dayMonthYear.length != 3 || hourMinute.length != 2){
                this.printHelp();
            }
            this.start.set(Integer.valueOf(dayMonthYear[2]), Integer.valueOf(dayMonthYear[1]), Integer.valueOf(dayMonthYear[0]), Integer.valueOf(hourMinute[0]), Integer.valueOf(hourMinute[1]), 0);

            System.out.println("Start date set");

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
        args1.add("equipmentId");
        Command command1 = new Command("add",args1, this, "add", "descriptionHere");
        Command command2 = new Command("remove", args1, this, "add", "descriptionHere");

        List<String> args3 = new LinkedList<>();
        args3.add("dd/MM/yyyy start");
        args3.add("hh/mm start");
        Command command3 = new Command("start", args3, this, "setStart", "descriptionHere");

        List<String> args4 = new LinkedList<>();
        args4.add("dd/MM/yyyy end");
        args4.add("hh/mm end");
        Command command4 = new Command("end", args4, this, "setEnd", "descriptionHere");

        Command command5 = new Command("validate", new LinkedList<String>(), this, "validate", "descriptionHere");
        Command command6 = new Command("cancel", new LinkedList<String>(), this, "cancel", "descriptionHere");
        Command command7 = new Command("show", new LinkedList<String>(), this, "show", "descriptionHere");

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
