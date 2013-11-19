
package model.caracteristique;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import lib.MapUtils;
import model.Caracteristique;

import com.google.gson.internal.LinkedTreeMap;

import config.Config;

/**
 * The Class OperatingSystem.
 */
public class OperatingSystem extends Caracteristique implements
        model.finder.IString {

    // Cet attribut est chargé a l'aide d'un fichier de configuration JSON
    /** The accetable value. */
    private List<String> accetableValue;

    /*
     * (non-Javadoc)
     * 
     * @see model.finder.IString#equals(model.finder.IString)
     */
    @Override
    public boolean equals( model.finder.IString object ) {

        return object.getClass( ).equals( this.getClass( ) )
                && this.getValue( ).equals(
                        ( ( OperatingSystem ) object ).getValue( ) );
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

    /*
     * (non-Javadoc)
     * 
     * @see model.ICaracteristique#getName()
     */
    @Override
    public String getName( ) {

        return "OperatingSystem";
    }

    /**
     * Instantiates a new operating system.
     * 
     * @param os
     *            the os
     * @param typeMateriel
     *            the type materiel
     * @throws InvalidParameterException
     *             the invalid parameter exception
     */
    public OperatingSystem( String os, String typeMateriel )
            throws InvalidParameterException {

        this.setAccetableValue( typeMateriel );
        this.checkOS( os );

    }

    /**
     * Sets the accetable value.
     * 
     * @param typeMateriel
     *            the new accetable value
     * @throws InvalidParameterException
     *             the invalid parameter exception
     */
    private void setAccetableValue( String typeMateriel )
            throws InvalidParameterException {

        if( typeMateriel == null ) {

            Map fullmap = new LinkedTreeMap( );
            for( Entry entry : ( Set<Entry> ) ( ( Map ) Config
                    .getConfiguration( ).get( "materiel" ) ).entrySet( ) ) {

                if( ( Map ) ( ( Map ) ( ( Map ) Config.getConfiguration( ).get(
                        "materiel" ) ).get( entry.getKey( ) ) ).get( this
                        .getName( ) ) != null ) {
                    fullmap.putAll( ( Map ) ( ( Map ) ( ( Map ) Config
                            .getConfiguration( ).get( "materiel" ) ).get( entry
                            .getKey( ) ) ).get( this.getName( ) ) );
                }

            }

            this.accetableValue = MapUtils.MapKeyToList( fullmap );

        } else {

            if( ( ( LinkedTreeMap ) Config.getConfiguration( ).get( "materiel" ) )
                    .containsKey( typeMateriel ) ) {
                this.accetableValue = MapUtils
                        .MapKeyToList( ( LinkedTreeMap ) ( ( LinkedTreeMap ) ( ( LinkedTreeMap ) Config
                                .getConfiguration( ).get( "materiel" ) )
                                .get( typeMateriel ) ).get( this.getName( ) ) );

            } else {

                throw new InvalidParameterException( typeMateriel
                        + " do not exist" );

            }

        }

    }

    /**
     * Check os.
     * 
     * @param os
     *            the os
     * @throws InvalidParameterException
     *             the invalid parameter exception
     */
    private void checkOS( String os ) throws InvalidParameterException {

        if( !this.accetableValue.contains( os ) ) {
            throw new InvalidParameterException( "Your OS does not exist" );
        } else {
            this.setValue( os );
        }
    }

    /**
     * Instantiates a new operating system.
     * 
     * @param os
     *            the os
     * @throws InvalidParameterException
     *             the invalid parameter exception
     */
    public OperatingSystem( String os ) throws InvalidParameterException {

        // Definition de acceptableValue
        this.setAccetableValue( null );
        this.checkOS( os );

    }
}
