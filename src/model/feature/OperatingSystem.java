
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
    private List<String> acceptableValue;

    /** The Constant name. */
    @Expose
    private final String name = "OperatingSystem";

    /**
     * Instantiates a new operating system.
     *
     * @param os
     *            the os
     * @throws InvalidParameterException
     *             the invalid parameter exception
     */
    public OperatingSystem( final String os ) throws InvalidParameterException {

        // Definition de acceptableValue
        this.setAcceptableValue(null);
        this.checkOS( os );

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
    public OperatingSystem( final String os, final String typeMateriel )
            throws InvalidParameterException {

        this.setAcceptableValue(typeMateriel);
        this.checkOS( os );

    }

    /**
     * Check os.
     *
     * @param os
     *            the os
     * @throws InvalidParameterException
     *             the invalid parameter exception
     */
    private void checkOS( final String os ) throws InvalidParameterException {

        if( !this.acceptableValue.contains( os ) ) {
            throw new InvalidParameterException( "Your OS does not exist" );
        } else {
            this.setValue( os );
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( final Object obj ) {

        return this.getClass( ).getName( ).equals( obj.getClass( ).getName( ) )
                && this.getValue( ).equals(
                        ( ( OperatingSystem ) obj ).getValue( ) );
    }

    @Override
    public String getInfo( ) {

        return (String)((Map)Config.getConfiguration().get(Config.FEATURE)).get(this.name);
    }

    /*
     * (non-Javadoc)
     *
     * @see model.IFeature#getName()
     */
    @Override
    public String getName( ) {

        return this.name;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode( ) {

        int result = this.acceptableValue.hashCode( );
        result = 31 * result + this.name.hashCode( );
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
     * @param typeMateriel
     *            the new accetable value
     * @throws InvalidParameterException
     *             the invalid parameter exception
     */
    private void setAcceptableValue(final String typeMateriel)
            throws InvalidParameterException {

        if( typeMateriel == null ) {

            final List<String> fullList = new ArrayList<String>( );
            for( final Entry entry : ( Set<Entry> ) ( ( Map ) Config
                    .getConfiguration( ).get( Config.EQUIPMENT ) ).entrySet( ) ) {

                if(  ( ( Map ) ( ( Map ) Config.getConfiguration( )
                        .get( Config.EQUIPMENT ) ).get( entry.getKey( ) ) )
                        .get( this.name ) != null ) {

                    fullList.addAll((List) ((Map) ((Map) Config.getConfiguration().get(Config.EQUIPMENT)).get(entry.getKey())).get(this.name));
                }

            }

            this.acceptableValue = fullList;

        } else {

            if( ( ( LinkedTreeMap ) Config.getConfiguration( ).get(
                    Config.EQUIPMENT ) ).containsKey( typeMateriel ) ) {
                this.acceptableValue = ( List ) ( ( LinkedTreeMap ) ( ( LinkedTreeMap ) Config
                        .getConfiguration( ).get( Config.EQUIPMENT ) )
                        .get( typeMateriel ) ).get( this.name );

            } else {

                throw new InvalidParameterException( typeMateriel
                        + " do not exist" );

            }

        }

    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString( ) {
        String template = (String)((Map)((Map)Config.getConfiguration().get("template")).get("features")).get(this.name);
        template = template.replaceAll("\\{name\\}", this.name);
        template = template.replaceAll("\\{value\\}", this.getValue());

        return template;
    }
}
