
package views.etat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import views.Command;
import views.View;

/**
 * The Class Borrower.
 */
public class Borrower extends User {

    /**
     * Borrow.
     */
    private void borrow( ) {
        View.setState( new Borrow( ) );
    }

    /*
     * (non-Javadoc)
     *
     * @see views.IView#setCommands()
     */
    @Override
    public List<Command> setCommands() {

        final List<Command> commands = new ArrayList<>( );

        final Command command1 = new Command( "borrow",
                new LinkedList<String>( ), this, "borrow", "descriptionHere" );
        commands.add( command1 );
        commands.addAll( super.setCommands() );

        return commands;

    }
}
