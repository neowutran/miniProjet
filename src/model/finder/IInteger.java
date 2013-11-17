package model.finder;

/**
 * Created by draragar on 17/11/13.
 */
public interface IInteger {

    public boolean equals(IString object);

    public boolean greaterThan(IString object);

    public boolean lesserThan(IString object);

    public boolean greaterThanOrEquals(IString object);

    public boolean lesserThanOrEquals(IString object);

}
