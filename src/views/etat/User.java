package views.etat;

import model.*;
import views.*;
import views.State;

import java.util.*;

/**
 * The Class User.
 */
public abstract class User extends State {

    private void logout() {

        model.User.getInstance().logout();
        View.setState(new Main());
        System.out.println("logged out");
    }

    private void find() {

        View.setState(new Find());
    }

    private void list_borrow() {

        System.out.println(Inventory.getInstance().getBorrows());
    }

    private void list_equipment() {

        System.out.println(Inventory.getInstance().getEquipments());
    }

    @Override
    public List<Command> defineOptions() {

        List<Command> commands = new ArrayList<>();

        Command command3 = new Command("logout", new LinkedList<String>(), this, "logout", "descriptionHere");
        Command command4 = new Command("list_borrow", new LinkedList<String>(), this, "list_borrow", "descriptionHere");
        Command command5 = new Command("list_equipment", new LinkedList<String>(), this, "list_equipment", "descriptionHere");

        List<String> args6 = new LinkedList<>();
        args6.add("borrowId");
        Command command6 = new Command("show_borrow", args6, this, "show_borrow", "descriptionHere");

        List<String> args7 = new LinkedList<>();
        args7.add("equipmentId");
        Command command7 = new Command("show_equipment", args7, this, "show_equipment", "descriptionHere");

        List<String> args8 = new LinkedList<>();
        args8.add("personId");
        Command command8 = new Command("show_person", args8, this, "show_person", "descriptionHere");

        List<String> args9 = new LinkedList<>();
        args9.add("dd/MM/yyyy start");
        args9.add("hh:mm start");
        args9.add("dd/MM/yyyy end");
        args9.add("hh:mm end");
        Command command9 = new Command("list_available_equipment", args9, this, "list_available_equipment", "descriptionHere");

        Command command10 = new Command("find", new LinkedList<String>(), this, "find", "descriptionHere");

        commands.add(command3);
        commands.add(command4);
        commands.add(command5);
        commands.add(command6);
        commands.add(command7);
        commands.add(command8);
        commands.add(command9);
        commands.add(command10);

        commands.addAll(super.defineOptions());

        return commands;
    }

    private void show_borrow(String id) {

        System.out.println(Finder.findBorrowById(id));

    }

    private void show_equipment(String id) {

        System.out.println(Finder.findEquipmentById(id));

    }

    private void show_person(String id) {

        System.out.println(Finder.findPersonById(id));

    }

    private void list_available_equipment(String startDayMonthYear, String startHourMinute, String endDayMonthYear, String endHourMinute ) {

        final Calendar start = Calendar.getInstance();
        final Calendar end = Calendar.getInstance();

        final String[] stringStartDayMonthYear = startDayMonthYear.split("/");
        final String[] stringStartHourMinute = startHourMinute.split(":");

        final String[] stringEndDayMonthYear = endDayMonthYear.split("/");
        final String[] stringEndHourMinute = endHourMinute.split(":");

        if (stringEndDayMonthYear.length != 3 || stringEndHourMinute.length != 2 || stringStartDayMonthYear.length != 3 || stringStartHourMinute.length != 2) {
            this.printHelp();
            return;
        }

        start.set(Integer.valueOf(stringStartDayMonthYear[2]), Integer.valueOf(stringStartDayMonthYear[1]), Integer.valueOf(stringStartDayMonthYear[0]), Integer.valueOf(stringStartHourMinute[0]), Integer.valueOf(stringStartHourMinute[1]), 0);

        end.set(Integer.valueOf(stringEndDayMonthYear[2]), Integer.valueOf(stringEndDayMonthYear[1]), Integer.valueOf(stringEndDayMonthYear[0]), Integer.valueOf(stringEndHourMinute[0]), Integer.valueOf(stringEndHourMinute[1]), 0);

        System.out.println(Finder.findAvailable(start, end));
    }

}


