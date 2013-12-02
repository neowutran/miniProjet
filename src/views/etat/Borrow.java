
package views.etat;

import java.text.SimpleDateFormat;
import java.util.*;

import model.Finder;
import model.User;
import views.Command;
import views.State;
import views.View;

// TODO: Auto-generated Javadoc
/**
 * The Class Borrow.
 */
public class Borrow extends State {

    /** The equipments. */
    private final List<String> equipments = new ArrayList<>( );

    /** The start. */
    private final Calendar     start      = Calendar.getInstance( );

    /** The end. */
    private final Calendar     end        = Calendar.getInstance( );

    /**
     * Adds the.
     *
     * @param id the id
     */
    private void add( final String id ) {
        this.equipments.add( id );
        System.out.println( "Equipment " + id + " added" );

    }

    /**
     * Cancel.
     */
    private void cancel( ) {
        View.setState( new Borrower( ) );
    }

    /*
     * (non-Javadoc)
     *
     * @see views.IView#defineOptions()
     */
    @Override
    public List<Command> defineOptions( ) {

        final List<Command> commands = new ArrayList<>( );

        final List<String> args1 = new LinkedList<>( );
        args1.add( "equipmentId" );
        final Command command1 = new Command( "add", args1, this, "add",
                "descriptionHere" );
        final Command command2 = new Command( "remove", args1, this, "add",
                "descriptionHere" );

        final List<String> args3 = new LinkedList<>( );
        args3.add( "dd/MM/yyyy start" );
        args3.add( "hh/mm start" );
        final Command command3 = new Command( "start", args3, this, "setStart",
                "descriptionHere" );

        final List<String> args4 = new LinkedList<>( );
        args4.add( "dd/MM/yyyy end" );
        args4.add( "hh/mm end" );
        final Command command4 = new Command( "end", args4, this, "setEnd",
                "descriptionHere" );

        final Command command5 = new Command( "validate",
                new LinkedList<String>( ), this, "validate", "descriptionHere" );
        final Command command6 = new Command( "cancel",
                new LinkedList<String>( ), this, "cancel", "descriptionHere" );
        final Command command7 = new Command( "show",
                new LinkedList<String>( ), this, "show", "descriptionHere" );

        commands.add( command1 );
        commands.add( command2 );
        commands.add( command3 );
        commands.add( command4 );
        commands.add( command5 );
        commands.add( command6 );
        commands.add( command7 );
        commands.addAll( super.defineOptions( ) );

        return commands;

    }

    /**
     * Removes the.
     *
     * @param id the id
     */
    private void remove( final String id ) {

        this.equipments.remove( id );
        System.out.println( "Equipment " + id + " removed" );

    }

    /**
     * Sets the end.
     *
     * @param stringDayMonthYear the string day month year
     * @param stringHourMinute the string hour minute
     */
    private void setEnd( final String stringDayMonthYear,
            final String stringHourMinute ) {

        final String[ ] dayMonthYear = stringDayMonthYear.split( "/" );
        final String[ ] hourMinute = stringHourMinute.split( ":" );
        if( dayMonthYear.length != 3 || hourMinute.length != 2 ) {
            this.printHelp( );
        }

        this.end.set( Integer.valueOf( dayMonthYear[ 2 ] ),
                Integer.valueOf( dayMonthYear[ 1 ])-1,
                Integer.valueOf( dayMonthYear[ 0 ] ),
                Integer.valueOf( hourMinute[ 0 ] ),
                Integer.valueOf( hourMinute[ 1 ] ), 0 );

        System.out.println( "end date set" );

    }

    /**
     * Sets the start.
     *
     * @param stringDayMonthYear the string day month year
     * @param stringHourMinute the string hour minute
     */
    private void setStart( final String stringDayMonthYear,
            final String stringHourMinute ) {

        final String[ ] dayMonthYear = stringDayMonthYear.split( "/" );
        final String[ ] hourMinute = stringHourMinute.split( ":" );
        if( dayMonthYear.length != 3 || hourMinute.length != 2 ) {
            this.printHelp( );
        }

        this.start.set( Integer.valueOf( dayMonthYear[ 2 ] ),
                Integer.valueOf( dayMonthYear[ 1 ] )-1,
                Integer.valueOf( dayMonthYear[ 0 ] ),
                Integer.valueOf( hourMinute[ 0 ] ),
                Integer.valueOf( hourMinute[ 1 ] ), 0 );
        System.out.println( "start date set" );

    }

    /**
     * Show.
     */
    private void show( ) {
        final SimpleDateFormat format = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm" );
        final String show = "equipment:" + this.equipments + "\n" + "start:"
                + format.format( this.start.getTime( ) ) + "\n" + "end:"
                + format.format( this.end.getTime( ) );
        System.out.println( show );

    }

    /**
     * Validate.
     */
    private void validate( ) {
        if( Finder.isBorrowed( this.equipments, this.start, this.end ) ) {
            System.out.println( "Equipment unavailable" );
            return;
        }

        ( ( model.person.Borrower ) Finder.findPersonById( User.getInstance( )
                .getPersonneId( ) ) ).borrow( this.equipments, this.start,
                this.end );
        System.out.println( "Borrowed." );
    }
}
