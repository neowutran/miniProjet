package model;

import config.Config;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;

/**
 * Created by draragar on 17/11/13.
 */
public class Materiel {

    private Integer quantity;
    private Integer quantityAvaiable;
    private String type;
    private List<Caracteristique> attributs;

    public Materiel(String type, List<Caracteristique> attributs, Integer quantity, Integer quantityAvaiable) throws InvalidParameterException {

        checkType(type);
        checkAttribut(attributs);
        checkQuantity(quantity);
        checkQuantityAvaiable(quantityAvaiable);
    }

    private void checkType(String type) throws InvalidParameterException {

        if (!((Map) Config.getConfiguration().get("materiel")).containsKey(type)) {

            throw new InvalidParameterException(type + " does not exist");

        }

        this.type = type;

    }

    public Integer getQuantityAvaiable() {

        return quantityAvaiable;
    }

    public void setQuantityAvaiable(Integer quantityAvaiable) {

        checkQuantityAvaiable(quantityAvaiable);
    }

    private void checkQuantityAvaiable(Integer quantity) throws InvalidParameterException {

        if (quantity == null) {
            throw new InvalidParameterException("Avaiable quantity cannot be null");
        }
        if (quantity < 0) {
            throw new InvalidParameterException("Avaiable quantity must be >= 0");
        }
        this.quantityAvaiable = quantity;
    }

    public Integer getQuantity() {

        return quantity;
    }

    public void setQuantity(final Integer quantity) {

        checkQuantity(quantity);

    }

    private void checkQuantity(Integer quantity) throws InvalidParameterException {

        if (quantity == null || quantity < 1)
            throw new InvalidParameterException("Quantity cannot be null");

        this.quantity = quantity;

    }

    public List<model.Caracteristique> getAttributs() {

        return attributs;
    }

    public void setAttributs(final List<model.Caracteristique> attributs) throws InvalidParameterException {

        checkAttribut(attributs);
    }

    private void checkAttribut(List<Caracteristique> attributs) throws InvalidParameterException {

        if (attributs == null)
            return;
        for (ICaracteristique caracteristique : attributs) {

            if (!((Map) ((Map) Config.getConfiguration().get("materiel")).get(this.type)).containsKey(caracteristique.getName())) {
                throw new InvalidParameterException(caracteristique.getName() + " does not exist on " + this.type);
            }

        }

        this.attributs = attributs;

    }

    @Override
    public boolean equals(Object obj) {

        return this.type.equals(((Materiel) obj).type) && (this.attributs.equals(((Materiel) obj).type));
    }

}
