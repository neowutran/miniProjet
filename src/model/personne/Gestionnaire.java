package model.personne;

// TODO: Auto-generated Javadoc
/**
 * The Class Gestionnaire.
 */
public class Gestionnaire extends model.Personne {

    /**
     * Sets the etat emprunt.
     *
     * @param emprunt the emprunt
     * @param etat the etat
     */
    public void setEtatEmprunt(Emprunteur.Emprunt emprunt, model.Etat etat) {

        emprunt.setEtat(etat, this);


    }

}
