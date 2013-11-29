
package model;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.google.gson.annotations.Expose;

import config.Config;

/**
 * The Class Equipment.
 */
public class Equipment {

    /** The type. */
    @Expose
    private String        type;

    /** The features. */
    @Expose
    private List<Feature> features;

    /** The id. */
    @Expose
    private String        id;

    /**
     * Instantiates a new equipment.
     *
     * @param type
     *            the type
     * @param features
     *            the features
     * @throws InvalidParameterException
     *             the invalid parameter exception
     */
    public Equipment( final String type, final List<Feature> features )
            throws InvalidParameterException {

        this.checkType( type );
        this.checkFeature( features );
        this.setId( );

        final List<Equipment> inventory = Inventory.getInstance( )
                .getEquipments( );
        inventory.add( this );
        Inventory.getInstance( ).setEquipments( inventory );

    }

    /**
     * Check feature.
     *
     * @param features
     *            the features
     * @throws InvalidParameterException
     *             the invalid parameter exception
     */
    private void checkFeature( final List<Feature> features )
            throws InvalidParameterException {

        if( ( null == features ) || features.isEmpty( ) ) {
            return;
        }
        for( final Feature feature : features ) {

            if( !( ( Map ) ( ( Map ) Config.getConfiguration( ).get(
                    Config.EQUIPMENT ) ).get( this.type ) )
                    .containsKey( feature.getName( ) ) ) {
                throw new InvalidParameterException( feature.getName( )
                        + " does not exist on " + this.type );
            }

        }

        this.features = features;

    }

    /**
     * Check type.
     *
     * @param type
     *            the type
     * @throws InvalidParameterException
     *             the invalid parameter exception
     */
    private void checkType( final String type )
            throws InvalidParameterException {

        if( !( ( Map ) Config.getConfiguration( ).get( Config.EQUIPMENT ) )
                .containsKey( type ) ) {

            throw new InvalidParameterException( type + " does not exist" );

        }

        this.type = type;

    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( final Object obj ) {

        return this.getClass( ).equals( obj.getClass( ) )
                && this.type.equals( ( ( Equipment ) obj ).type )
                && this.features.equals( ( ( Equipment ) obj ).features );
    }

    /**
     * Gets the features.
     *
     * @return the features
     */
    public List<model.Feature> getFeatures( ) {

        return this.features;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId( ) {

        return this.id;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode( ) {

        int result = this.type.hashCode( );
        result = ( 31 * result )
                + ( this.features != null ? this.features.hashCode( ) : 0 );
        result = ( 31 * result ) + this.id.hashCode( );
        return result;
    }

    /**
     * Sets the features.
     *
     * @param features
     *            the new features
     * @throws InvalidParameterException
     *             the invalid parameter exception
     */
    public void setFeatures( final List<model.Feature> features )
            throws InvalidParameterException {

        this.checkFeature( features );
    }

    /**
     * Sets the id.
     */
    private void setId( ) {

        do {
            // Possibilité de boucle "infini" ici. Tres TRES peu probable, et
            // pour l'interet du projet, flemme de reflechir a un correctif.
            this.id = UUID.randomUUID( ).toString( );
        } while( Finder.findEquipmentById( this.id ) != null );

    }

    /**
     * Sets the id.
     *
     * @param id
     *            the new id
     */
    public void setId( final String id ) {
        this.id = id;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString( ) {

        return "Materiel{\n" + "\ttype='" + this.type + "\'\n" + "\tattributs="
                + this.features + ",\n" + "\tid='" + this.id + "\'\n" + "}\n";
    }

}
