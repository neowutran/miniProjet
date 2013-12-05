
package config;

import java.util.Map;

/**
 * The Class Error.
 */
public class Error {

    /** The Constant CANNOT_CREATE_PERSON. */
    public final static String CANNOT_CREATE_PERSON      = ( String ) ( ( Map ) Config
                                                                 .getConfiguration()
                                                                 .get("error") )
                                                                 .get("1");
    
/** The Constant PERSON_ALREADY_EXIST. */
    public final static String PERSON_ALREADY_EXIST      = ( String ) ( ( Map ) Config
                                                                 .getConfiguration()
                                                                 .get("error") )
                                                                 .get("2");

    /** The Constant CANNOT_USE_THIS_OPERATOR. */
    public final static String CANNOT_USE_THIS_OPERATOR  = ( String ) ( ( Map ) Config
                                                                 .getConfiguration()
                                                                 .get("error") )
                                                                 .get("3");

    /** The Constant FEATURE_DOESNT_EXIST. */
    public final static String FEATURE_DOESNT_EXIST      = ( String ) ( ( Map ) Config
                                                                 .getConfiguration()
                                                                 .get("error") )
                                                                 .get("4");

    /** The Constant NOT_SAME_SIZE. */
    public final static String NOT_SAME_SIZE             = ( String ) ( ( Map ) Config
                                                                 .getConfiguration()
                                                                 .get("error") )
                                                                 .get("5");

    /** The Constant INVALID_ID. */
    public final static String INVALID_ID                = ( String ) ( ( Map ) Config
                                                                 .getConfiguration()
                                                                 .get("error") )
                                                                 .get("6");

    /** The Constant EQUIPMENT_DO_NOT_EXIST. */
    public final static String EQUIPMENT_DO_NOT_EXIST    = ( String ) ( ( Map ) Config
                                                                 .getConfiguration()
                                                                 .get("error") )
                                                                 .get("7");

    /** The Constant FEATURE_EQUIPMENT_INVALID. */
    public final static String FEATURE_EQUIPMENT_INVALID = ( String ) ( ( Map ) Config
                                                                 .getConfiguration()
                                                                 .get("error") )
                                                                 .get("8");

    /** The Constant EQUIPMENT_ALREADY_EXIST. */
    public final static String EQUIPMENT_ALREADY_EXIST   = ( String ) ( ( Map ) Config
                                                                 .getConfiguration()
                                                                 .get("error") )
                                                                 .get("9");

    /** The Constant RANDOM_ERROR. */
    public final static String RANDOM_ERROR              = ( String ) ( ( Map ) Config
                                                                 .getConfiguration()
                                                                 .get("error") )
                                                                 .get("10");

    /** The Constant UNIMPLEMENTED. */
    public final static String UNIMPLEMENTED             = ( String ) ( ( Map ) Config
                                                                 .getConfiguration()
                                                                 .get("error") )
                                                                 .get("11");

    /** The Constant CANNOT_BORROW_SO_LONG. */
    public final static String CANNOT_BORROW_SO_LONG     = ( String ) ( ( Map ) Config
                                                                 .getConfiguration()
                                                                 .get("error") )
                                                                 .get("12");

    /** The Constant INVALID_DATE. */
    public final static String INVALID_DATE              = ( String ) ( ( Map ) Config
                                                                 .getConfiguration()
                                                                 .get("error") )
                                                                 .get("13");

    /** The Constant EQUIPMENT_UNAVAILABLE. */
    public final static String EQUIPMENT_UNAVAILABLE     = ( String ) ( ( Map ) Config
                                                                 .getConfiguration()
                                                                 .get("error") )
                                                                 .get("14");

    /** The Constant CANNOT_BORROW_ADVANCE. */
    public final static String CANNOT_BORROW_ADVANCE     = ( String ) ( ( Map ) Config
                                                                 .getConfiguration()
                                                                 .get("error") )
                                                                 .get("15");

    /** The Constant OS_DO_NOT_EXIST. */
    public final static String OS_DO_NOT_EXIST           = ( String ) ( ( Map ) Config
                                                                 .getConfiguration( )
                                                                 .get( "error" ) )
                                                                 .get( "16" );

    /**
     * Instantiates a new error.
     */
    private Error( ) {

    }

}
