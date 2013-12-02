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


    /** The state. */
    private static State state    = new Main();


    /**
     * Gets the state.
     *
     * @return the state
     */
    public static State getState( ) {

        return state;
    }

    /**
     * Sets the state.
     *
     * @param state
     *            the new state
     */
    public static void setState( State state ) {
        View.state = state;
    }


    /**
     * Instantiates a new view.
     */
    public static void launch( ) {
        System.out.println("Welcome to miniProject version 0.1 (pray for not having a bug)");
        readLine();
    }

    /**
     * Read line.
     */
    private static void readLine( ) {

        while( true ) {

            final Scanner scanner = new Scanner( System.in );
            final String line = scanner.nextLine( );
            state.interpreter( line );

        }

    }

}
