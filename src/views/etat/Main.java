
package views.etat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Finder;
import views.Command;
import views.State;
import views.View;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main extends State {

    /*
     * (non-Javadoc)
     * 
     * @see views.IView#defineOptions()
     */
    @Override
    public List<Command> defineOptions( ) {

        final List<Command> commands = new ArrayList<>( );

        final List<String> args1 = new LinkedList<>( );
        args1.add( "id" );
        args1.add( "password" );
        final Command command1 = new Command( "login", args1, this, "login",
                "descriptionHere" );

        commands.add( command1 );
        commands.addAll( super.defineOptions( ) );

        return commands;

    }

    /**
     * Login.
     *
     * @param id the id
     * @param password the password
     */
    private void login( final String id, final String password ) {

        if( model.User.getInstance( ).login( id, password ) ) {

            System.out.println( "Welcome "
                    + Finder.findPersonById( id ).getName( ) );
            if( Finder.isBorrower( id ) ) {
                View.setState( new Borrower( ) );
            } else {
                View.setState( new Administrator( ) );
            }

        } else {

            System.out.println( "Mauvais utilisateur ou mot de passe" );

        }

    }
}
