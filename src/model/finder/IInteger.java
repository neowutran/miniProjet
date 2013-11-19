package model.finder;

// TODO: Auto-generated Javadoc
/**
 * The Interface IInteger.
 */
public interface IInteger {

    /**
     * Equals.
     *
     * @param object the object
     * @return true, if successful
     */
    public boolean equals(IString object);

    /**
     * Greater than.
     *
     * @param object the object
     * @return true, if successful
     */
    public boolean greaterThan(IString object);

    /**
     * Lesser than.
     *
     * @param object the object
     * @return true, if successful
     */
    public boolean lesserThan(IString object);

    /**
     * Greater than or equals.
     *
     * @param object the object
     * @return true, if successful
     */
    public boolean greaterThanOrEquals(IString object);

    /**
     * Lesser than or equals.
     *
     * @param object the object
     * @return true, if successful
     */
    public boolean lesserThanOrEquals(IString object);

}
