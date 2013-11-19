package model;

import model.personne.Emprunteur;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Inventaire.
 */
public final class Inventaire {

    /**
     * Gets the materiel.
     *
     * @return the materiel
     */
    public static java.util.List<Materiel> getMateriel() {

        return materiel;
    }

    /**
     * Sets the materiel.
     *
     * @param materiel the new materiel
     */
    public static void setMateriel(final java.util.List<Materiel> materiel) {

        Inventaire.materiel = materiel;
    }

    /** The materiel. */
    private static java.util.List<Materiel> materiel;

    /**
     * Gets the emprunts.
     *
     * @return the emprunts
     */
    public static List<Emprunteur.Emprunt> getEmprunts() {

        return emprunts;
    }

    /** The emprunts. */
    private static List<Emprunteur.Emprunt> emprunts;

    /**
     * Adds the emprunt.
     *
     * @param emprunt the emprunt
     */
    public static void addEmprunt(Emprunteur.Emprunt emprunt) {

        emprunts.add(emprunt);

    }

    // Materiel materiel = Finder.findMateriel(emprunt.getMateriel());
    //materiel.setQuantityAvaiable(materiel.getQuantityAvaiable() - emprunt.getQuantity());
}
