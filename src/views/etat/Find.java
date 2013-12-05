
package views.etat;

import java.security.*;
import java.text.*;
import java.util.*;

import model.*;
import model.User;
import views.*;
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

    private String type;

    /**
     * Adds the.
     *
     * @param id the id
     */
    private void add( final String feature , final String operator, final String value) {
        this.features.add(feature);
        this.operators.add(operator);
        this.values.add(value);
        System.out.println( "Condition: "+feature+" "+operator+" "+value+" added" );

    }

    /**
     * Cancel.
     */
    private void cancel( ) {
        if( Finder.isBorrower(model.User.getInstance().getPersonId())){
            View.setState(new Borrower());

        }else{
            View.setState(new Administrator());

        }
    }

    /**
     * Show.
     */
    private void show( ) {


        final String show = "type:" + this.type + "\n"+values;
        System.out.println( show );

    }

    /**
     * Validate.
     */
    private void validate( ) {


        try {
            List<Equipment> equipments = Finder.find(type, features, operators, values);
            System.out.println(equipments);
        } catch (MiniProjectException e) {
            e.printStackTrace();
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see views.IView#setCommands()
     */
    @Override
    public List<Command> setCommands() {


        final List<Command> commands = new ArrayList<>( );

        final List<String> args1 = new LinkedList<>( );
        args1.add("feature");
        args1.add("operator");
        args1.add( "value" );
        final Command command1 = new Command( "add", args1, this, "add",
                "descriptionHere" );

        final List<String> args2 = new LinkedList<>( );
        args2.add("type");
        final Command command2 = new Command( "type", args2, this, "type",
                "descriptionHere" );

        final Command command5 = new Command( "validate",
                new LinkedList<String>( ), this, "validate", "descriptionHere" );
        final Command command6 = new Command( "cancel",
                new LinkedList<String>( ), this, "cancel", "descriptionHere" );
        final Command command7 = new Command( "show",
                new LinkedList<String>( ), this, "show", "descriptionHere" );

        commands.add( command1 );
        commands.add( command2 );
        commands.add( command5 );
        commands.add( command6 );
        commands.add( command7 );
        commands.addAll( super.setCommands() );

        return commands;

    }

}
