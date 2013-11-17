package model;

/**
 * Created by draragar on 17/11/13.
 */
public abstract class Materiel {

    private Integer quantity;

    public Integer getQuantity() {

        return quantity;
    }

    public java.util.HashMap<model.ICaracteristique, Object> getAttributs() {

        return attributs;
    }

    public void setAttributs(final java.util.HashMap<model.ICaracteristique, Object> attributs) {

        this.attributs = attributs;
    }

    public void setQuantity(final Integer quantity) {

        this.quantity = quantity;
    }

    private java.util.HashMap<ICaracteristique, Object> attributs;

    public Materiel(java.util.HashMap<ICaracteristique, Object> attributs, Integer quantity) {

        this.quantity = quantity;
        this.attributs = attributs;
    }

    public void acceptableMateriel() {
        //TODO
        //Teste le hashmap de caracteristique pour verifier la coerrence en fonction du type de materiel
    }

}
