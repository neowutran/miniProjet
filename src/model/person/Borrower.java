
package model.person;

import java.security.InvalidParameterException;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import model.Finder;
import model.Inventory;
import model.State;

import com.google.gson.annotations.Expose;
import com.google.gson.internal.LinkedTreeMap;

import config.Config;
import controllers.MiniProjectController;


/**
 * The Class Borrower.
 */
public abstract class Borrower extends model.Person {

    /**
     * The Class Borrow.
     */
    public final class Borrow {

        /** The id. */
        @Expose
        private String             id;

        /** The equipment id. */
        @Expose
        private List<String>       equipmentId;

        /** The borrower id. */
        @Expose
        private String             borrowerId;

        /** The administrator id. */
        @Expose
        private String             administratorId;

        /** The state. */
        @Expose
        private model.State        state = model.State.ASK_BORROW;

        /** The borrow start. */
        @Expose
        private java.util.Calendar borrowStart;

        /** The borrow end. */
        @Expose
        private java.util.Calendar borrowEnd;

        /** The returned. */
        private Calendar           returned;

        /**
         * Instantiates a new borrow.
         */
        private Borrow( ) {

        }

        /**
         * Instantiates a new borrow.
         *
         * @param equipments the equipments
         * @param borrowStart the borrow start
         * @param borrowEnd the borrow end
         * @throws Exception the exception
         */
        private Borrow( final List<String> equipments,
                final java.util.Calendar borrowStart,
                final java.util.Calendar borrowEnd ) throws Exception {

            this.equipmentId = equipments;
            this.borrowerId = Borrower.this.getId( );
            this.borrowStart = borrowStart;
            this.borrowEnd = borrowEnd;
            this.setId( );

        }

        /**
         * Gets the borrow end.
         *
         * @return the borrow end
         */
        public java.util.Calendar getBorrowEnd( ) {

            return this.borrowEnd;
        }

        /**
         * Gets the borrower id.
         *
         * @return the borrower id
         */
        public String getBorrowerId( ) {

            return this.borrowerId;
        }

        /**
         * Gets the borrow start.
         *
         * @return the borrow start
         */
        public java.util.Calendar getBorrowStart( ) {

            return this.borrowStart;
        }

        /**
         * Gets the equipment id.
         *
         * @return the equipment id
         */
        public List<String> getEquipmentId( ) {

            return this.equipmentId;
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
         * Gets the returned.
         *
         * @return the returned
         */
        public Calendar getReturned( ) {

            return this.returned;
        }

        /**
         * Gets the state.
         *
         * @return the state
         */
        public model.State getState( ) {

            return this.state;
        }

        /**
         * Sets the id.
         *
         * @throws Exception the exception
         */
        private void setId( ) throws Exception {

            // TODO mettre cette valeur en fichier de config
            Integer maxCounter = 1000;
            do {

                if( maxCounter == 0 ) {
                    throw new Exception(
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
         */
        public void setId( final String id ) {

            this.id = id;
        }

        /**
         * Sets the returned.
         *
         * @param returned the new returned
         * @throws InvalidParameterException the invalid parameter exception
         */
        public void setReturned( final Calendar returned )
                throws InvalidParameterException {

            if( returned == null ) {
                throw new InvalidParameterException(
                        "return date cannot be null" );
            }
            this.returned = returned;
            this.state = State.RETURNED;
        }

        /**
         * Sets the state.
         *
         * @param state the state
         * @param administrator the administrator
         * @throws Exception the exception
         */
        public void setState( final model.State state,
                final String administrator ) throws Exception {

            if( this.state.equals( state ) ) {
                return;
            }
            if( State.ACCEPT.equals( state )
                    && Finder.isBorrowed( this.getEquipmentId( ),
                            this.getBorrowStart( ), this.getBorrowEnd( ) ) ) {

                throw new Exception( "Le materiel n'est plus disponible" );

            }

            this.state = state;
            this.administratorId = administrator;
        }

        /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString( ) {

            return "Emprunt{" + "id='" + this.id + '\'' + ", equipmentId="
                    + this.equipmentId + ", borrowerId='" + this.borrowerId
                    + '\'' + ", administratorId='" + this.administratorId
                    + '\'' + ", state=" + this.state + ", borrowStart="
                    + this.borrowStart + ", borrowEnd=" + this.borrowEnd
                    + ", returned=" + this.returned + '}';
        }

    }

    /** The maximum advance days. */
    private final Long maximumAdvanceDays;

    /** The maximum hours. */
    private final Long maximumHours;

    /**
     * Instantiates a new borrower.
     *
     * @param name the name
     * @param id the id
     * @param type the type
     * @param password the password
     */
    public Borrower( final String name, final String id, final String type,
            final String password ) {

        super( name, id, password );
        this.setType( type );
        this.maximumAdvanceDays = ( ( Double ) ( ( LinkedTreeMap ) ( ( LinkedTreeMap ) Config
                .getConfiguration().get( Config.BORROWER ) ).get( this
                .getType() ) ).get( Config.MAXIMUM_ADVANCE_DAY ) ).longValue( );
        this.maximumHours = ( ( Double ) ( ( LinkedTreeMap ) ( ( LinkedTreeMap ) Config
                .getConfiguration().get( Config.BORROWER ) ).get( this
                .getType() ) ).get( Config.MAXIMUM_HOUR ) ).longValue( );

    }

    /**
     * Borrow.
     *
     * @param equipment the equipment
     * @param start the start
     * @param end the end
     * @return the string
     * @throws InvalidParameterException the invalid parameter exception
     */
    public String borrow( final List<String> equipment, final Calendar start,
            final Calendar end ) throws InvalidParameterException {

        if( start.getTimeInMillis( ) >= end.getTimeInMillis( )
                || start.getTimeInMillis( ) > Calendar.getInstance( )
                        .getTimeInMillis( ) ) {
            throw new InvalidParameterException( "Date invalide" );
        }
        if( Finder.isBorrowed( equipment, start, end ) ) {
            throw new InvalidParameterException( "Materiel unavaiable" );
        }

        final Calendar now = Calendar.getInstance( );
        final Long maximumAdvance = 1000 * 60 * 60 * 24
                * this.maximumAdvanceDays;
        if( start.getTimeInMillis( ) - now.getTimeInMillis( ) > maximumAdvance
                && this.maximumAdvanceDays != 0 ) {
            throw new InvalidParameterException(
                    "Vous ne pouvez pas borrow autant a l'avance, maximum: "
                            + this.maximumAdvanceDays + " jours" );
        }

        final Long maximumTimeDuration = 1000 * 60 * 60 * this.maximumHours;
        if( end.getTimeInMillis( ) - start.getTimeInMillis( ) > maximumTimeDuration
                && this.maximumHours != 0 ) {
            throw new InvalidParameterException(
                    "Vous ne pouvez pas borrow pour plus de: "
                            + this.maximumHours + " heures" );
        }

        // TODO calcul de durée autorisé
        Borrow borrow = null;
        try {
            borrow = new Borrow( equipment, start, end );
        } catch( final Exception e ) {
            MiniProjectController.LOGGER.severe( java.util.Arrays.toString( e
                    .getStackTrace() ) );
            return null;
        }
        Inventory.getInstance( ).addBorrow( borrow );
        return borrow.getId( );

    }
}
