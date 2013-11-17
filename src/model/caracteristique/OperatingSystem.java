package model.caracteristique;

/**
 * Created by draragar on 17/11/13.
 */
public class OperatingSystem implements model.finder.IString, model.ICaracteristique {

    private String value;

    //Config
    private java.util.List<String> accetableValue;

    @Override
    public boolean equals(model.finder.IString object) {

        return object instanceof OperatingSystem && this.value.equals(((OperatingSystem) object).value);
    }

    @Override
    public String getInfos() {

        return "Systeme d'exploitation";
    }

    @Override
    public String getName() {

        return "OS";
    }

    public OperatingSystem(String os) throws Exception {

        if (!accetableValue.contains(os)) {
            throw new Exception("TODO");
        } else {
            this.value = os;
        }
    }
}
