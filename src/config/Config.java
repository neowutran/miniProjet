/*
 * @author Martini Didier
 */

package config;

/**
 * The Class Config.
 */
public final class Config {

    /** The Constant EQUIPMENT. */
    public static final String                   EQUIPMENT           = "equipment";

    /** The Constant BORROWER. */
    public static final String                   BORROWER            = "borrower";

    /** The Constant MAXIMUM_ADVANCE_DAY. */
    public static final String                   MAXIMUM_ADVANCE_DAY = "maximum_advance_days";

    /** The Constant MAXIMUM_HOUR. */
    public static final String                   MAXIMUM_HOUR        = "maximum_hours";

    public static final String                   FEATURE             = "feature";

    /** The configuration. */
    private static java.util.Map<String, Object> configuration;

    /**
     * Gets the configuration.
     * 
     * @return the configuration
     */
    public static java.util.Map<String, Object> getConfiguration( ) {

        return config.Config.configuration;
    }

    /**
     * Sets the configuration.
     * 
     * @param configuration
     *            the configuration
     */
    public static void setConfiguration(
            final java.util.Map<String, Object> configuration ) {

        config.Config.configuration = configuration;
    }

    /**
     * Instantiates a new config.
     */
    private Config( ) {

    }

}
