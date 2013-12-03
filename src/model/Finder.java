
package model;

import java.lang.reflect.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.finder.*;
import model.person.Borrower;
import model.person.Borrower.Borrow;

/**
 * The Class Finder.
 */
public final class Finder {

    private static Boolean evaluate(String featureString, String operator, String value, Feature feature ) throws MiniProjectException {

        Integer type = 0;
        try {
            Class classFeature = Class.forName("model.feature."+featureString);
            Class interfaceFeature[] = classFeature.getInterfaces();
            for (final Class anInterfaceFeature : interfaceFeature) {
                if (anInterfaceFeature.equals(IString.class) && type != 2) {
                    type = 1;
                }
                if (anInterfaceFeature.equals(IInteger.class)) {
                    type = 2;
                }
            }

            if(type == 0){
                throw new MiniProjectException("this feature doesn't exist");

            }

            switch(operator){
                case "=":

                       return (Boolean)feature.getClass().getMethod("isEquals", String.class).invoke(value);

                case ">=":

                    if(type != 2){
                        throw new MiniProjectException("you can use this operator on this feature");
                    }
                    return (Boolean)feature.getClass().getMethod("greaterThanOrEquals", String.class).invoke(value);

                case "<=":
                    if(type != 2){
                        throw new MiniProjectException("you can use this operator on this feature");
                    }
                    return (Boolean)feature.getClass().getMethod("lesserThanOrEquals", String.class).invoke(value);

                case "<":
                    if(type != 2){
                        throw new MiniProjectException("you can use this operator on this feature");
                    }
                    return (Boolean)feature.getClass().getMethod("lesserThan", String.class).invoke(value);

                case ">":
                    if(type != 2){
                        throw new MiniProjectException("you can use this operator on this feature");
                    }
                    return (Boolean)feature.getClass().getMethod("greaterThan", String.class).invoke(value);

            }


        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return false;

    }

    public static List<Equipment> find(List<String> features, List<String> operators, List<String> value) throws MiniProjectException {
        checkSize(features, operators, value);
        List<Equipment> equipments = new ArrayList<>();
        for(Equipment equipment: Inventory.getInstance().getEquipments()){

            boolean good = true;
            for(int i = 0; i < features.size(); i++){


                for(Feature equipmentFeature: equipment.getFeatures()){

                   if(!evaluate(features.get(i),operators.get(i),value.get(i), equipmentFeature)){
                       good = false;
                   }

                }

            }

            if(good){
                equipments.add(equipment);
            }


        }

        return equipments;
    }
    /**
     * Check size.
     *
     * @param features the features
     * @param operator the operator
     * @param value the value
     * @throws InvalidParameterException the invalid parameter exception
     */
    private static void checkSize( final List<String> features,
            final List<String> operator, final List<String> value )
            throws InvalidParameterException {

        if( features.size( ) != operator.size( )
                || operator.size( ) != value.size( ) ) {
            throw new InvalidParameterException( "Not same size" );
        }

    }

    /**
     * Find actual borrow by borrower.
     *
     * @param borrowerId the borrower id
     * @return the list
     */
    public static List<Borrow> findActualBorrowByBorrower(
            final String borrowerId ) {
        final List<Borrow> borrows = new ArrayList<>( );

        for( final Borrow borrow : Inventory.getInstance( ).getBorrows( ) ) {

            if( borrow.getBorrowerId( ).equals( borrowerId )
                    && !borrow.getState( ).equals( State.RETURNED ) ) {
                borrows.add( borrow );
            }

        }
        return borrows;
    }

    /**
     * Find available.
     *
     * @param start the start
     * @param end the end
     * @return the list
     */
    public static List<Equipment> findAvailable( final Calendar start,
            final Calendar end ) {

        final List<Equipment> equipments = new ArrayList<>( );
        for( final Equipment equipment : Inventory.getInstance( )
                .getEquipments( ) ) {

            Boolean available = true;

            for( final Borrow borrow : Inventory.getInstance( ).getBorrows( ) ) {

                if( borrow.getEquipmentId( ).contains( equipment.getId( ) )
                        && borrow.getBorrowStart( ).getTimeInMillis( ) < end
                                .getTimeInMillis( )
                        && borrow.getBorrowEnd( ).getTimeInMillis( ) > start
                                .getTimeInMillis( ) ) {

                    available = false;

                }

            }

            if( available ) {
                equipments.add( equipment );
            }

        }
        return equipments;

    }

    /**
     * Find borrow by borrower.
     *
     * @param borrowerId the borrower id
     * @return the list
     */
    public static List<Borrow> findBorrowByBorrower( final String borrowerId ) {

        final List<Borrow> borrows = new ArrayList<>( );
        for( final Borrow borrow : Inventory.getInstance( ).getBorrows( ) ) {

            if( borrow.getBorrowerId( ).equals( borrowerId ) ) {
                borrows.add( borrow );
            }

        }
        return borrows;

    }

    /**
     * Find borrow by id.
     *
     * @param id the id
     * @return the borrow
     */
    public static Borrow findBorrowById( final String id ) {

        for( final Borrow borrow : Inventory.getInstance( ).getBorrows( ) ) {
            if( borrow.getId( ).equals( id ) ) {
                return borrow;
            }
        }

        return null;
    }

    /**
     * Find borrow waiting for administrator.
     *
     * @return the list
     */
    public static List<Borrow> findBorrowWaitingForAdministrator( ) {
        final List<Borrow> borrows = new ArrayList<>( );
        for( final Borrow borrow : Inventory.getInstance( ).getBorrows( ) ) {
            if( borrow.getState( ).equals( State.ASK_BORROW ) ) {
                borrows.add( borrow );
            }
        }
        return borrows;
    }

    /**
     * Find equipment by id.
     *
     * @param id the id
     * @return the equipment
     */
    public static Equipment findEquipmentById( final String id ) {

        for( final Equipment equipment : Inventory.getInstance( )
                .getEquipments( ) ) {
            if( equipment.getId( ).equals( id ) ) {
                return equipment;
            }
        }

        return null;

    }

    public static Integer findQuantityEquipment(final Equipment findEquipment){

        Integer quantity = 0;
        for(Equipment equipment: Inventory.getInstance().getEquipments()){

            if(equipment.equals(findEquipment)){
                quantity++;
            }

        }
        return quantity;

    }

    /**
     * Find late borrow.
     *
     * @return the list
     */
    public static List<Borrow> findLateBorrow( ) {
        final List<Borrow> borrows = new ArrayList<>( );
        for( final Borrow borrow : Inventory.getInstance( ).getBorrows( ) ) {

            if( borrow.getBorrowEnd( ).getTimeInMillis( ) < Calendar
                    .getInstance( ).getTimeInMillis( ) ) {
                borrows.add( borrow );
            }

        }
        return borrows;
    }

    /**
     * Find person by id.
     *
     * @param id the id
     * @return the person
     */
    public static Person findPersonById( final String id ) {

        for( final Person person : Person.getPersons( ) ) {
            if( person.getId( ).equals( id ) ) {
                return person;
            }
        }

        return null;
    }

    /**
     * Checks if is borrowed.
     *
     * @param equipmentsId the equipments id
     * @param start the start
     * @param end the end
     * @return true, if is borrowed
     */
    public static boolean isBorrowed( final List<String> equipmentsId,
            final Calendar start, final Calendar end ) {

        for( final Borrow borrow : Inventory.getInstance( ).getBorrows( ) ) {
            for( final String borrowEquipment : borrow.getEquipmentId( ) ) {
                for( final String materielId : equipmentsId ) {
                    if( borrowEquipment.equals( materielId )
                            && borrow.getBorrowStart( ).getTimeInMillis( ) < end
                                    .getTimeInMillis( )
                            && borrow.getBorrowEnd( ).getTimeInMillis( ) > start
                                    .getTimeInMillis( )
                            && borrow.getState( ).equals( State.ACCEPT ) ) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if is borrower.
     *
     * @param id the id
     * @return true, if is borrower
     * @throws InvalidParameterException the invalid parameter exception
     */
    public static boolean isBorrower( final String id )
            throws InvalidParameterException {

        final Person person = Finder.findPersonById( id );
        if( person == null ) {
            throw new InvalidParameterException( "id invalide" );
        }
        return person.getClass( ).getSuperclass( ).equals( Borrower.class );

    }

    /**
     * Instantiates a new finder.
     */
    private Finder( ) {

    }
}
