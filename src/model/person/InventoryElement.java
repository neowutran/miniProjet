
package model.person;

import java.util.UUID;

import model.Finder;
import model.MiniProjectException;

import com.google.gson.annotations.Expose;

import config.Config;

/**
 * The Class InventoryElement.
 */
public abstract class InventoryElement {

    /** The id. */
    @Expose
    private String id;

    /**
     * Check existence.
     *
     * @param id the id
     * @throws MiniProjectException the mini project exception
     */
    protected void checkExistence( final String id )
            throws MiniProjectException {
        throw new MiniProjectException( "Unimplemented" );
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId( ) {

        return this.id;
    }

    /**
     * Sets the id.
     *
     * @throws MiniProjectException the mini project exception
     */
    protected void setId( ) throws MiniProjectException {

        Integer maxCounter = ( ( Double ) Config.getConfiguration( ).get(
                "random_counter" ) ).intValue( );
        do {

            if( maxCounter == 0 ) {
                throw new MiniProjectException(
                        "The random generator isn't enough random anymore" );
            }
            maxCounter--;
            this.id = UUID.randomUUID( ).toString( );

        } while( Finder.findEquipmentById( this.id ) != null );

    }

    /**
     * Sets the id.
     *
     * @param id the new id
     * @throws MiniProjectException the mini project exception
     */
    public void setId( final String id ) throws MiniProjectException {

        if( this.id.equals( id ) ) {
            return;
        }

        this.checkExistence( id );

        this.id = id;
    }

}
