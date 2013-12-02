
package views.etat;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.cli.CommandLine;

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
    private void add( final CommandLine line ) {

    }

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

    /**
     * Sets the end.
     *
     * @param line the new end
     */
    private void setEnd( final CommandLine line ) {
        if( line.getArgList( ).size( ) != 3 ) {
            this.printHelp( );
        } else {
            final String[ ] dayMonthYear = ( ( String ) line.getArgList( ).get(
                    1 ) ).split( "/" );
            final String[ ] hourMinute = ( ( String ) line.getArgList( )
                    .get( 2 ) ).split( ":" );
            if( dayMonthYear.length != 3 || hourMinute.length != 2 ) {
                this.printHelp( );
            }

            this.end.set( Integer.valueOf( dayMonthYear[ 2 ] ),
                    Integer.valueOf( dayMonthYear[ 1 ] ),
                    Integer.valueOf( dayMonthYear[ 0 ] ),
                    Integer.valueOf( hourMinute[ 0 ] ),
                    Integer.valueOf( hourMinute[ 1 ] ), 0 );

            System.out.println( "end date set" );
        }

    }

    /**
     * Sets the start.
     *
     * @param line the new start
     */
    private void setStart( final CommandLine line ) {
        if( line.getArgList( ).size( ) != 3 ) {
            this.printHelp( );
        } else {
            final String[ ] dayMonthYear = ( ( String ) line.getArgList( ).get(
                    1 ) ).split( "/" );
            final String[ ] hourMinute = ( ( String ) line.getArgList( )
                    .get( 2 ) ).split( ":" );
            if( dayMonthYear.length != 3 || hourMinute.length != 2 ) {
                this.printHelp( );
            }
            this.start.set( Integer.valueOf( dayMonthYear[ 2 ] ),
                    Integer.valueOf( dayMonthYear[ 1 ] ),
                    Integer.valueOf( dayMonthYear[ 0 ] ),
                    Integer.valueOf( hourMinute[ 0 ] ),
                    Integer.valueOf( hourMinute[ 1 ] ), 0 );

            System.out.println( "Start date set" );
        }
    }
}
