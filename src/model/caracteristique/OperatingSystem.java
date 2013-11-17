package model.caracteristique;

import java.util.*;

/**
 * Created by draragar on 17/11/13.
 */
public class OperatingSystem implements model.finder.IString, model.ICaracteristique {

    private String value;

    //Config
    private List<String> accetableValue;

    @Override
    public boolean equals(model.finder.IString object) {

        return object.getClass().equals(this.getClass()) && this.value.equals(((OperatingSystem) object).value);
    }

    @Override
    public String getInfos() {

        return "Systeme d'exploitation";
    }

    public OperatingSystem(String os, String typeMateriel) throws Exception {

        //Definition de accetableValue
        this(os);
    }

    public OperatingSystem(String os) throws Exception {

        //Definition de acceptableValue
        if (!accetableValue.contains(os)) {
            throw new Exception("TODO");
        } else {
            this.value = os;
        }
    }
}
