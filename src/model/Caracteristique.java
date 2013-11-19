package model;

/**
 * Created by draragar on 19/11/13.
 */
public abstract class Caracteristique {

    protected String getValue() {

        return value;
    }

    protected void setValue(final String value) {

        this.value = value;
    }

    private String value;


}
