package model;

/**
 * Created by draragar on 17/11/13.
 */
public class Emprunt {

    private Materiel materiel;
    private Integer quantity;
    private model.personne.Emprunteur emprunteur;

    public java.util.Calendar getFinEmprunt() {

        return finEmprunt;
    }

    public model.Materiel getMateriel() {

        return materiel;
    }

    public Integer getQuantity() {

        return quantity;
    }

    public model.personne.Emprunteur getEmprunteur() {

        return emprunteur;
    }

    public model.personne.Gestionnaire getGestionnaire() {

        return gestionnaire;
    }

    public void setGestionnaire(final model.personne.Gestionnaire gestionnaire) {

        this.gestionnaire = gestionnaire;
    }

    public model.Etat getEtat() {

        return etat;
    }

    public void setEtat(final model.Etat etat) {

        this.etat = etat;
    }

    public java.util.Calendar getDebutEmprunt() {

        return debutEmprunt;
    }

    private model.personne.Gestionnaire gestionnaire;
    private model.Etat etat = model.Etat.DEMANDE_EMPRUNT;
    private java.util.Calendar debutEmprunt;
    private java.util.Calendar finEmprunt;

    public Emprunt(Materiel materiel, Integer quantity, model.personne.Emprunteur emprunteur, java.util.Calendar debutEmprunt, java.util.Calendar finEmprunt) {

        this.materiel = materiel;
        this.quantity = quantity;
        this.emprunteur = emprunteur;
        this.debutEmprunt = debutEmprunt;
        this.finEmprunt = finEmprunt;

    }

    public boolean isPossible() {
        //TODO
        return false;
    }

}
