
package views.etat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.Finder;
import model.Inventory;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;

import views.View;

/**
 * The Class User.
 */
public final class User {

    /**
     * Action.
     *
     * @param line
     *            the line
     * @return true, if successful
     */
    public static boolean action( final CommandLine line ) {

        if( line.getArgList( ).isEmpty( ) ) {
            return false;
        }
        boolean action = true;

        switch( ( String ) line.getArgList( ).get( 0 ) ) {
        case "list_borrow":
            System.out.println( Inventory.getInstance( ).getBorrows( ) );
            break;
        case "list_equipment":
            System.out.println( Inventory.getInstance( ).getEquipments( ) );
            break;
        case "show_borrow":
            if( line.getArgList( ).size( ) != 2 ) {
                System.out.println( "Usage: show_borrow <id_borrow>" );
            } else {
                final String id = ( String ) line.getArgList( ).get( 1 );
                System.out.println( Finder.findBorrowById( id ) );
            }
            break;
        case "show_equipment":
            if( line.getArgList( ).size( ) != 2 ) {
                System.out.println( "Usage: show_equipment <id_equipment>" );
            } else {
                final String id = ( String ) line.getArgList( ).get( 1 );
                System.out.println( Finder.findEquipmentById( id ) );
            }
            break;
        case "show_person":
            if( line.getArgList( ).size( ) != 2 ) {
                System.out.println( "Usage: show_person <id_person>" );
            } else {
                final String id = ( String ) line.getArgList( ).get( 1 );
                System.out.println( Finder.findPersonById( id ) );
            }
            break;
        case "find":
            View.setState( new Find( ) );
            break;
        case "list_available_equipment":

            if( line.getArgList( ).size( ) != 3 ) {
                System.out
                        .println("Usage: list_available_equipment <calendar> <calendar>");
            } else {
                final Calendar start = Calendar.getInstance( );
                final Calendar end = Calendar.getInstance( );

                final String id = ( String ) line.getArgList( ).get( 1 );
                System.out.println( Finder.findPersonById( id ) );

                final String stringStart = ( String ) line.getArgList( )
                        .get(1);
                final String stringEnd = ( String ) line.getArgList( ).get( 2 );

                final DateFormat formatter = new SimpleDateFormat( "dd/MM/yy" );
                Date dateStart = null;
                Date dateEnd = null;
                try {
                    dateStart = formatter.parse( stringStart );
                    dateEnd = formatter.parse( stringEnd );
                } catch( final ParseException e ) {
                    e.printStackTrace( );
                }

                start.setTime( dateStart );
                end.setTime( dateEnd );

                System.out.println( Finder.findAvailable( start, end ) );
            }

            break;
        default:
            action = false;
            break;
        }

        return action;
    }

    /**
     * Sets the options.
     *
     * @return the options
     */
    public static Options setOptions( ) {

        final Options options = new Options( );
        options.addOption( OptionBuilder.withLongOpt( "exit" ).create( ) );
        options.addOption( OptionBuilder.withArgName( "list_borrow" ).hasArgs( )
                .withValueSeparator().withDescription( "list des emprunts" )
                .create("list_borrow") );
        options.addOption( OptionBuilder.withArgName( "list_materiel" )
                .hasArgs().withValueSeparator( )
                .withDescription("list du materiel")
                .create("list_equipment") );
        options.addOption( OptionBuilder.withArgName( "show_borrow" )
                .hasArgs(1).withValueSeparator( )
                .withDescription("affiche un emprunt par son id")
                .create("show_borrow") );
        options.addOption( OptionBuilder.withArgName( "show_equipment" )
                .hasArgs(1).withValueSeparator( )
                .withDescription("affiche un materiel par son id")
                .create("show_equipment") );
        options.addOption( OptionBuilder.withArgName( "show_person" )
                .hasArgs(1).withValueSeparator( )
                .withDescription("affiche une person par son id")
                .create("show_person") );
        options.addOption( OptionBuilder
                .withArgName("list_available_equipment")
                .hasArgs(2)
                .withValueSeparator()
                .withDescription("affiche la liste des equipement disponible entre deux dates")
                .create("list_available_equipment") );
        final Option help = new Option( "help", "help" );
        options.addOption( help );

        return options;
    }

    /**
     * Instantiates a new user.
     */
    private User( ) {

    }
}
