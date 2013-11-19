package model;

/**
 * Created by draragar on 19/11/13.
 */
public abstract class Caracteristique implements model.ICaracteristique {

    private String value;

    protected String getValue() {

        return value;
    }

    protected void setValue(final String value) {

        this.value = value;

    }

}
