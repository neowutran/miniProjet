
package views.etat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import model.Finder;
import model.Inventory;
import views.Command;
import views.State;
import views.View;

/**
 * The Class User.
 */
public abstract class User extends State {

    /* (non-Javadoc)
     * @see views.State#setCommands()
     */
    @Override
    public List<Command> setCommands() {

        final List<Command> commands = new ArrayList<>( );

        final Command command3 = new Command( "logout",
                new LinkedList<String>( ), this, "logout", "descriptionHere" );
        final Command command4 = new Command( "list_borrow",
                new LinkedList<String>( ), this, "list_borrow",
                "descriptionHere" );
        final Command command5 = new Command( "list_equipment",
                new LinkedList<String>( ), this, "list_equipment",
                "descriptionHere" );

        final List<String> args6 = new LinkedList<>( );
        args6.add( "borrowId" );
        final Command command6 = new Command( "show_borrow", args6, this,
                "show_borrow", "descriptionHere" );

        final List<String> args7 = new LinkedList<>( );
        args7.add( "equipmentId" );
        final Command command7 = new Command( "show_equipment", args7, this,
                "show_equipment", "descriptionHere" );

        final List<String> args8 = new LinkedList<>( );
        args8.add( "personId" );
        final Command command8 = new Command( "show_person", args8, this,
                "show_person", "descriptionHere" );

        final List<String> args9 = new LinkedList<>( );
        args9.add( "dd/MM/yyyy start" );
        args9.add( "hh:mm start" );
        args9.add( "dd/MM/yyyy end" );
        args9.add( "hh:mm end" );
        final Command command9 = new Command( "list_available_equipment",
                args9, this, "list_available_equipment", "descriptionHere" );

        final Command command10 = new Command( "find",
                new LinkedList<String>( ), this, "find", "descriptionHere" );

        commands.add( command3 );
        commands.add( command4 );
        commands.add( command5 );
        commands.add( command6 );
        commands.add( command7 );
        commands.add( command8 );
        commands.add( command9 );
        commands.add( command10 );

        commands.addAll( super.setCommands() );

        return commands;
    }

    /**
     * Find.
     */
    public void find( ) {

        View.setState( new Find( ) );
    }

    /**
     * List_available_equipment.
     *
     * @param startDayMonthYear the start day month year
     * @param startHourMinute the start hour minute
     * @param endDayMonthYear the end day month year
     * @param endHourMinute the end hour minute
     */
    public void list_available_equipment( final String startDayMonthYear,
            final String startHourMinute, final String endDayMonthYear,
            final String endHourMinute ) {

        final Calendar start = Calendar.getInstance( );
        final Calendar end = Calendar.getInstance( );

        final String[ ] stringStartDayMonthYear = startDayMonthYear.split( "/" );
        final String[ ] stringStartHourMinute = startHourMinute.split( ":" );

        final String[ ] stringEndDayMonthYear = endDayMonthYear.split( "/" );
        final String[ ] stringEndHourMinute = endHourMinute.split( ":" );

        if( stringEndDayMonthYear.length != 3
                || stringEndHourMinute.length != 2
                || stringStartDayMonthYear.length != 3
                || stringStartHourMinute.length != 2 ) {
            this.printHelp( );
            return;
        }

        start.set( Integer.valueOf( stringStartDayMonthYear[ 2 ] ),
                Integer.valueOf( stringStartDayMonthYear[ 1 ] ) -1,
                Integer.valueOf( stringStartDayMonthYear[ 0 ] ),
                Integer.valueOf( stringStartHourMinute[ 0 ] ),
                Integer.valueOf( stringStartHourMinute[ 1 ] ), 0 );

        end.set( Integer.valueOf( stringEndDayMonthYear[ 2 ] ),
                Integer.valueOf( stringEndDayMonthYear[ 1 ] ) -1,
                Integer.valueOf( stringEndDayMonthYear[ 0 ] ),
                Integer.valueOf( stringEndHourMinute[ 0 ] ),
                Integer.valueOf( stringEndHourMinute[ 1 ] ), 0 );

        System.out.println( Finder.findAvailable( start, end ) );
    }

    /**
     * List_borrow.
     */
    public void list_borrow( ) {

        System.out.println( Inventory.getInstance( ).getBorrows( ) );
    }

    /**
     * List_equipment.
     */
    public void list_equipment( ) {

        System.out.println( Inventory.getInstance( ).getEquipments( ) );
    }

    /**
     * Logout.
     */
    public void logout( ) {

        model.User.getInstance( ).logout( );
        View.setState( new Main( ) );
        System.out.println( "logged out" );
    }

    /**
     * Show_borrow.
     *
     * @param id the id
     */
    public void show_borrow( final String id ) {

        System.out.println( Finder.findBorrowById( id ) );

    }

    /**
     * Show_equipment.
     *
     * @param id the id
     */
    public void show_equipment( final String id ) {

        System.out.println( Finder.findEquipmentById( id ) );

    }

    /**
     * Show_person.
     *
     * @param id the id
     */
    public void show_person( final String id ) {

        System.out.println( Finder.findPersonById( id ) );

    }

}
