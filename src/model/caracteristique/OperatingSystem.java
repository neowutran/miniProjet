package model.caracteristique;

import com.google.gson.internal.*;
import config.*;
import lib.*;
import model.*;

import java.security.*;
import java.util.*;
import java.util.Map.*;

/**
 * Created by draragar on 17/11/13.
 */
public class OperatingSystem extends Caracteristique implements model.finder.IString, model.ICaracteristique {

    private List<String> accetableValue;

    @Override
    public boolean equals(model.finder.IString object) {

        return object.getClass().equals(this.getClass()) && this.getValue().equals(((OperatingSystem) object).getValue());
    }

    @Override
    public String getInfos() {

        return "Systeme d'exploitation";
    }

    @Override
    public String getName(){
        return "OperatingSystem";
    }

    public OperatingSystem(String os, String typeMateriel) throws InvalidParameterException {

        setAccetableValue(typeMateriel);
        checkOS(os);

    }

    private void setAccetableValue(String typeMateriel) throws InvalidParameterException {

        if (typeMateriel == null) {

            Map fullmap = new LinkedTreeMap();
            for (Entry entry : (Set<Entry>) ((Map) Config.getConfiguration().get("materiel")).entrySet()) {

                if ((Map) ((Map) ((Map) Config.getConfiguration().get("materiel")).get(entry.getKey())).get(this.getName()) != null) {
                    fullmap.putAll((Map) ((Map) ((Map) Config.getConfiguration().get("materiel")).get(entry.getKey())).get(this.getName()));
                }

            }

            this.accetableValue = MapUtils.MapKeyToList(fullmap);

        } else {

            if (((LinkedTreeMap) Config.getConfiguration().get("materiel")).containsKey(typeMateriel)) {
                this.accetableValue = MapUtils.MapKeyToList((LinkedTreeMap) ((LinkedTreeMap) ((LinkedTreeMap) Config.getConfiguration().get("materiel")).get(typeMateriel)).get(this.getName()));

            } else {

                throw new InvalidParameterException(typeMateriel + " do not exist");

            }

        }

    }

    private void checkOS(String os) throws InvalidParameterException {

        if (!accetableValue.contains(os)) {
            throw new InvalidParameterException("Your OS does not exist");
        } else {
            this.setValue(os);
        }
    }

    public OperatingSystem(String os) throws InvalidParameterException {

        //Definition de acceptableValue
        setAccetableValue(null);
        checkOS(os);

    }
}
