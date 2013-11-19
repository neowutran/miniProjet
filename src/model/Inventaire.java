package model;

import model.personne.Emprunteur;

import java.util.List;

/**
 * Created by draragar on 17/11/13.
 */
public final class Inventaire {

    public static java.util.List<Materiel> getMateriel() {

        return materiel;
    }

    public static void setMateriel(final java.util.List<Materiel> materiel) {

        Inventaire.materiel = materiel;
    }

    private static java.util.List<Materiel> materiel;

    public static List<Emprunteur.Emprunt> getEmprunts() {

        return emprunts;
    }

    private static List<Emprunteur.Emprunt> emprunts;

    public static void addEmprunt(Emprunteur.Emprunt emprunt) {

        emprunts.add(emprunt);

    }

    // Materiel materiel = Finder.findMateriel(emprunt.getMateriel());
    //materiel.setQuantityAvaiable(materiel.getQuantityAvaiable() - emprunt.getQuantity());
}
