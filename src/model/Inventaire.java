package model;

/**
 * Created by draragar on 17/11/13.
 */
public class Inventaire {

    public static java.util.List<Materiel> getMateriel() {

        return materiel;
    }

    public static void setMateriel(final java.util.List<Materiel> materiel) {

        Inventaire.materiel = materiel;
    }

    private static java.util.List<Materiel> materiel;

}
