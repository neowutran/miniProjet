package model;

import config.*;

import java.security.*;
import java.util.*;

/**
 * Created by draragar on 17/11/13.
 */
public class Materiel {

    private Integer quantity;
    private String type;

    public Integer getQuantity() {

        return quantity;
    }

    public List<model.ICaracteristique> getAttributs() {

        return attributs;
    }

    public void setAttributs(final List<model.ICaracteristique> attributs) throws InvalidParameterException {

        checkAttribut(attributs);
    }

    public void setQuantity(final Integer quantity) {

        checkQuantity(quantity);

    }

    private List<ICaracteristique> attributs;

    public Materiel(String type, List<ICaracteristique> attributs, Integer quantity) throws InvalidParameterException {

        checkType(type);
        checkAttribut(attributs);
        checkQuantity(quantity);
    }

    private void checkType(String type) throws InvalidParameterException {

        if (!((Map) Config.getConfiguration().get("materiel")).containsKey(type)) {

            throw new InvalidParameterException(type + " does not exist");

        }

        this.type = type;

    }

    private void checkAttribut(List<ICaracteristique> attributs) throws InvalidParameterException {

        if (attributs == null) return;
        for (ICaracteristique caracteristique : attributs) {

            if (!((Map) ((Map)Config.getConfiguration().get("materiel")).get(this.type)).containsKey(caracteristique.getName())) {
                throw new InvalidParameterException(caracteristique.getName() + " does not exist on " + this.type);
            }

        }

        this.attributs = attributs;

    }

    private void checkQuantity(Integer quantity) throws InvalidParameterException {

        if (quantity == null || quantity < 1) throw new InvalidParameterException("Quantity cannot be null");

        this.quantity = quantity;

    }

}
