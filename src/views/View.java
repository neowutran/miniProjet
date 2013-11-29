/*
 * @author Martini Didier
 */

package views;

import java.util.Scanner;

import views.etat.Main;

/**
 * The Class View.
 */
public class View {

    /** The instance. */
    private static View  instance = null;

    /** The state. */
    private static State state    = new Main( );

    /**
     * Gets the single instance of View.
     *
     * @return single instance of View
     */
    public static View getInstance( ) {
        if( View.instance == null ) {
            View.instance = new View( );
        }
        return View.instance;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public static State getState( ) {

        return View.state;
    }

    /**
     * Sets the state.
     *
     * @param state
     *            the new state
     */
    public static void setState( final State state ) {

        View.state = state;

    }

    /**
     * Instantiates a new view.
     */
    protected View( ) {
        this.readLine( );
    }

    /**
     * Read line.
     */
    private void readLine( ) {

        while( true ) {

            final Scanner scanner = new Scanner( System.in );
            final String line = scanner.nextLine( );
            View.state.interpreter(line);

        }

    }

}
