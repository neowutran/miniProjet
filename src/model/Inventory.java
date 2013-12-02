
package model;

import java.util.ArrayList;
import java.util.List;

import model.person.Borrower;

import com.google.gson.annotations.Expose;

/**
 * The Class Inventory.
 */
public final class Inventory {

    /** The instance. */
    private static Inventory instance = null;

    /**
     * Gets the single instance of Inventory.
     * 
     * @return single instance of Inventory
     */
    public static Inventory getInstance( ) {
        if( Inventory.instance == null ) {
            Inventory.instance = new Inventory( );
        }
        return Inventory.instance;
    }

    /** The equipments. */
    @Expose
    private java.util.List<Equipment>   equipments = new ArrayList<>( );

    /** The borrows. */
    @Expose
    private final List<Borrower.Borrow> borrows    = new ArrayList<>( );

    /**
     * Instantiates a new inventory.
     */
    protected Inventory( ) {
        // Exists only to defeat instantiation.
    }

    /**
     * Adds the borrow.
     * 
     * @param borrow
     *            the borrow
     */
    public void addBorrow( final Borrower.Borrow borrow ) {

        this.borrows.add( borrow );

    }

    /**
     * Gets the borrows.
     * 
     * @return the borrows
     */
    public List<Borrower.Borrow> getBorrows( ) {

        return this.borrows;
    }

    /**
     * Gets the equipments.
     * 
     * @return the equipments
     */
    public java.util.List<Equipment> getEquipments( ) {

        return this.equipments;
    }

    /**
     * Sets the equipments.
     * 
     * @param equipments
     *            the new equipments
     */
    public void setEquipments( final java.util.List<Equipment> equipments ) {

        this.equipments = equipments;
    }

}
