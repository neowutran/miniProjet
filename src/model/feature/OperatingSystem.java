
package model.feature;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import model.Feature;

import com.google.gson.annotations.Expose;
import com.google.gson.internal.LinkedTreeMap;

import config.Config;

/**
 * The Class OperatingSystem.
 */
public class OperatingSystem extends Feature implements model.finder.IString {

    // Cet attribut est chargé a l'aide d'un fichier de configuration JSON
    /** The accetable value. */
    private List<String>        accetableValue;

    /** The Constant NAME. */
    @Expose
    private static final String NAME = "OperatingSystem";

    /**
     * Instantiates a new operating system.
     *
     * @param os the os
     * @throws InvalidParameterException the invalid parameter exception
     */
    public OperatingSystem( final String os ) throws InvalidParameterException {

        // Definition de acceptableValue
        this.setAccetableValue( null );
        this.checkOS( os );

    }

    /**
     * Instantiates a new operating system.
     *
     * @param os the os
     * @param typeMateriel the type materiel
     * @throws InvalidParameterException the invalid parameter exception
     */
    public OperatingSystem( final String os, final String typeMateriel )
            throws InvalidParameterException {

        this.setAccetableValue( typeMateriel );
        this.checkOS( os );

    }

    /**
     * Check os.
     *
     * @param os the os
     * @throws InvalidParameterException the invalid parameter exception
     */
    private void checkOS( final String os ) throws InvalidParameterException {

        if( !this.accetableValue.contains( os ) ) {
            throw new InvalidParameterException( "Your OS does not exist" );
        } else {
            this.setValue( os );
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( final Object obj ) {

        return this.getClass( ).getName( ).equals( obj.getClass( ).getName( ) )
                && this.getValue( ).equals(
                        ( ( OperatingSystem ) obj ).getValue( ) );
    }

    /*
     * (non-Javadoc)
     *
     * @see model.ICaracteristique#getInfos()
     */
    @Override
    public String getInfos( ) {

        return "Systeme d'exploitation";
    }

    /* (non-Javadoc)
     * @see model.IFeature#getName()
     */
    @Override
    public String getName( ) {

        return OperatingSystem.NAME;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode( ) {

        int result = this.accetableValue.hashCode( );
        result = 31 * result + OperatingSystem.NAME.hashCode( );
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see model.finder.IString#equals(model.finder.IString)
     */
    @Override
    public boolean isEquals( final String string ) {

        return this.getValue( ).equals( string );
    }

    /**
     * Sets the accetable value.
     *
     * @param typeMateriel the new accetable value
     * @throws InvalidParameterException the invalid parameter exception
     */
    private void setAccetableValue( final String typeMateriel )
            throws InvalidParameterException {

        if( typeMateriel == null ) {

            final List<String> fulllist = new ArrayList<String>( );
            for( final Entry entry : ( Set<Entry> ) ( ( Map ) Config
                    .getConfiguration( ).get( Config.EQUIPMENT ) ).entrySet( ) ) {

                if( ( ArrayList ) ( ( Map ) ( ( Map ) Config.getConfiguration( )
                        .get( Config.EQUIPMENT ) ).get( entry.getKey( ) ) )
                        .get( OperatingSystem.NAME) != null ) {

                    fulllist.addAll( ( List ) ( ( Map ) ( ( Map ) Config
                            .getConfiguration( ).get( Config.EQUIPMENT ) )
                            .get( entry.getKey( ) ) )
                            .get( OperatingSystem.NAME) );
                }

            }

            this.accetableValue = fulllist;

        } else {

            if( ( ( LinkedTreeMap ) Config.getConfiguration( ).get(
                    Config.EQUIPMENT ) ).containsKey( typeMateriel ) ) {
                this.accetableValue = ( List ) ( ( LinkedTreeMap ) ( ( LinkedTreeMap ) Config
                        .getConfiguration( ).get( Config.EQUIPMENT ) )
                        .get( typeMateriel ) ).get( OperatingSystem.NAME);

            } else {

                throw new InvalidParameterException( typeMateriel
                        + " do not exist" );

            }

        }

    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString( ) {

        return OperatingSystem.NAME + "{\n" + "\tvalue='" + this.getValue( )
                + "\'\n" + "}\n";
    }
}
