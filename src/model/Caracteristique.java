package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Caracteristique.
 */
public abstract class Caracteristique implements model.ICaracteristique {

    /** The value. */
    private String value;

    /**
     * Gets the value.
     *
     * @return the value
     */
    protected String getValue() {

        return value;
    }

    /**
     * Sets the value.
     *
     * @param value the new value
     */
    protected void setValue(final String value) {

        this.value = value;

    }

}
