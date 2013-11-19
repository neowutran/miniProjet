package model;

import config.Config;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Materiel.
 */
public class Materiel {

    /** The quantity. */
    private Integer quantity;
    
    /** The quantity avaiable. */
    private Integer quantityAvaiable;
    
    /** The type. */
    private String type;
    
    /** The attributs. */
    private List<Caracteristique> attributs;

    /**
     * Instantiates a new materiel.
     *
     * @param type the type
     * @param attributs the attributs
     * @param quantity the quantity
     * @param quantityAvaiable the quantity avaiable
     * @throws InvalidParameterException the invalid parameter exception
     */
    public Materiel(String type, List<Caracteristique> attributs, Integer quantity, Integer quantityAvaiable) throws InvalidParameterException {

        checkType(type);
        checkAttribut(attributs);
        checkQuantity(quantity);
        checkQuantityAvaiable(quantityAvaiable);
    }

    /**
     * Check type.
     *
     * @param type the type
     * @throws InvalidParameterException the invalid parameter exception
     */
    private void checkType(String type) throws InvalidParameterException {

        if (!((Map) Config.getConfiguration().get("materiel")).containsKey(type)) {

            throw new InvalidParameterException(type + " does not exist");

        }

        this.type = type;

    }

    /**
     * Gets the quantity avaiable.
     *
     * @return the quantity avaiable
     */
    public Integer getQuantityAvaiable() {

        return quantityAvaiable;
    }

    /**
     * Sets the quantity avaiable.
     *
     * @param quantityAvaiable the new quantity avaiable
     */
    public void setQuantityAvaiable(Integer quantityAvaiable) {

        checkQuantityAvaiable(quantityAvaiable);
    }

    /**
     * Check quantity avaiable.
     *
     * @param quantity the quantity
     * @throws InvalidParameterException the invalid parameter exception
     */
    private void checkQuantityAvaiable(Integer quantity) throws InvalidParameterException {

        if (quantity == null) {
            throw new InvalidParameterException("Avaiable quantity cannot be null");
        }
        if (quantity < 0) {
            throw new InvalidParameterException("Avaiable quantity must be >= 0");
        }
        this.quantityAvaiable = quantity;
    }

    /**
     * Gets the quantity.
     *
     * @return the quantity
     */
    public Integer getQuantity() {

        return quantity;
    }

    /**
     * Sets the quantity.
     *
     * @param quantity the new quantity
     */
    public void setQuantity(final Integer quantity) {

        checkQuantity(quantity);

    }

    /**
     * Check quantity.
     *
     * @param quantity the quantity
     * @throws InvalidParameterException the invalid parameter exception
     */
    private void checkQuantity(Integer quantity) throws InvalidParameterException {

        if (quantity == null || quantity < 1)
            throw new InvalidParameterException("Quantity cannot be null");

        this.quantity = quantity;

    }

    /**
     * Gets the attributs.
     *
     * @return the attributs
     */
    public List<model.Caracteristique> getAttributs() {

        return attributs;
    }

    /**
     * Sets the attributs.
     *
     * @param attributs the new attributs
     * @throws InvalidParameterException the invalid parameter exception
     */
    public void setAttributs(final List<model.Caracteristique> attributs) throws InvalidParameterException {

        checkAttribut(attributs);
    }

    /**
     * Check attribut.
     *
     * @param attributs the attributs
     * @throws InvalidParameterException the invalid parameter exception
     */
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

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        return this.type.equals(((Materiel) obj).type) && (this.attributs.equals(((Materiel) obj).type));
    }

}
