package model.personne;

import model.Finder;
import model.Inventaire;
import model.Materiel;

import java.util.Calendar;

// TODO: Auto-generated Javadoc
/**
 * The Class Emprunteur.
 */
public abstract class Emprunteur extends model.Personne {

    /**
     * Emprunter.
     *
     * @param materiel the materiel
     * @param quantity the quantity
     * @param debut the debut
     * @param fin the fin
     * @return true, if successful
     */
    public boolean emprunter(model.Materiel materiel, Integer quantity, Calendar debut, Calendar fin) {

        if (Finder.findExactlyAvaiable(materiel, debut, fin) < quantity)
            return false;
        Inventaire.addEmprunt(new Emprunt(materiel, quantity, debut, fin));
        return true;

    }

    /**
     * The Class Emprunt.
     */
    public class Emprunt {

        /** The materiel. */
        private Materiel materiel;
        
        /** The quantity. */
        private Integer quantity;
        
        /** The emprunteur. */
        private model.personne.Emprunteur emprunteur;

        /**
         * Gets the fin emprunt.
         *
         * @return the fin emprunt
         */
        public java.util.Calendar getFinEmprunt() {

            return finEmprunt;
        }

        /**
         * Gets the materiel.
         *
         * @return the materiel
         */
        public model.Materiel getMateriel() {

            return materiel;
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
         * Gets the emprunteur.
         *
         * @return the emprunteur
         */
        public model.personne.Emprunteur getEmprunteur() {

            return emprunteur;
        }

        /**
         * Gets the gestionnaire.
         *
         * @return the gestionnaire
         */
        public model.personne.Gestionnaire getGestionnaire() {

            return gestionnaire;
        }

        /**
         * Sets the gestionnaire.
         *
         * @param gestionnaire the new gestionnaire
         */
        public void setGestionnaire(final model.personne.Gestionnaire gestionnaire) {

            this.gestionnaire = gestionnaire;
        }

        /**
         * Gets the etat.
         *
         * @return the etat
         */
        public model.Etat getEtat() {

            return etat;
        }

        /**
         * Sets the etat.
         *
         * @param etat the etat
         * @param gestionnaire the gestionnaire
         */
        public void setEtat(final model.Etat etat, final Gestionnaire gestionnaire) {

            this.etat = etat;
            this.gestionnaire = gestionnaire;
        }

        /**
         * Gets the debut emprunt.
         *
         * @return the debut emprunt
         */
        public java.util.Calendar getDebutEmprunt() {

            return debutEmprunt;
        }

        /** The gestionnaire. */
        private model.personne.Gestionnaire gestionnaire;
        
        /** The etat. */
        private model.Etat etat = model.Etat.DEMANDE_EMPRUNT;
        
        /** The debut emprunt. */
        private java.util.Calendar debutEmprunt;
        
        /** The fin emprunt. */
        private java.util.Calendar finEmprunt;

        /**
         * Instantiates a new emprunt.
         *
         * @param materiel the materiel
         * @param quantity the quantity
         * @param debutEmprunt the debut emprunt
         * @param finEmprunt the fin emprunt
         */
        private Emprunt(Materiel materiel, Integer quantity,java.util.Calendar debutEmprunt, java.util.Calendar finEmprunt) {

            this.materiel = materiel;
            this.quantity = quantity;
            this.emprunteur = Emprunteur.this;
            this.debutEmprunt = debutEmprunt;
            this.finEmprunt = finEmprunt;

        }

    }
}
