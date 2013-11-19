package model.personne;

import model.Finder;
import model.Inventaire;
import model.Materiel;

import java.util.Calendar;

/**
 * Created by draragar on 17/11/13.
 */
public abstract class Emprunteur extends model.Personne {

    public boolean emprunter(model.Materiel materiel, Integer quantity, Calendar debut, Calendar fin) {

        if (Finder.findExactlyAvaiable(materiel, debut, fin) < quantity)
            return false;
        Inventaire.addEmprunt(new Emprunt(materiel, quantity, debut, fin));
        return true;

    }

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

        public void setEtat(final model.Etat etat, final Gestionnaire gestionnaire) {

            this.etat = etat;
            this.gestionnaire = gestionnaire;
        }

        public java.util.Calendar getDebutEmprunt() {

            return debutEmprunt;
        }

        private model.personne.Gestionnaire gestionnaire;
        private model.Etat etat = model.Etat.DEMANDE_EMPRUNT;
        private java.util.Calendar debutEmprunt;
        private java.util.Calendar finEmprunt;

        private Emprunt(Materiel materiel, Integer quantity,java.util.Calendar debutEmprunt, java.util.Calendar finEmprunt) {

            this.materiel = materiel;
            this.quantity = quantity;
            this.emprunteur = Emprunteur.this;
            this.debutEmprunt = debutEmprunt;
            this.finEmprunt = finEmprunt;

        }

    }
}
