package model;

import model.personne.Emprunteur;

import java.security.InvalidParameterException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by draragar on 17/11/13.
 */
public class Finder {

    public static Materiel findMateriel(Materiel findMateriel) {

        List<Materiel> materiels = Inventaire.getMateriel();
        for (Materiel materiel : materiels) {
            if (materiel.equals(findMateriel))
                return materiel;
        }

        return null;

    }

    public static Integer findExactly(Materiel findMateriel) {

        List<Materiel> materiels = Inventaire.getMateriel();
        for (Materiel materiel : materiels) {

            if (materiel.equals(findMateriel)) {
                return materiel.getQuantity();
            }

        }

        return 0;

    }

    public static Integer findExactly(Materiel findMateriel, Calendar debut, Calendar fin) throws InvalidParameterException {

        if (debut.getTimeInMillis() >= fin.getTimeInMillis()) {
            throw new InvalidParameterException("debut >= fin");
        }
        Integer use = 0;
        List<Emprunteur.Emprunt> emprunts = Inventaire.getEmprunts();
        for (Emprunteur.Emprunt emprunt : emprunts) {

            if (emprunt.getMateriel().equals(findMateriel) && (emprunt.getDebutEmprunt().getTimeInMillis() < fin.getTimeInMillis() && emprunt.getFinEmprunt().getTimeInMillis() > debut.getTimeInMillis())) {
                use += emprunt.getQuantity();
            }

        }

        return use;
    }

    public static Integer findExactlyAvaiable(Materiel findMateriel, Calendar debut, Calendar fin) {

        return findExactly(findMateriel) - findExactly(findMateriel, debut, fin);

    }

    public static boolean find(List<Caracteristique> caracteristique, List<String> operateur, List<Object> value) throws Exception {

        checkSize(caracteristique, operateur, value);

        //TODO
        return false;
    }

    private static void checkSize(List<Caracteristique> caracteristiques, List<String> operateur, List<Object> value) throws InvalidParameterException {

        if (caracteristiques.size() != operateur.size() || operateur.size() != value.size())
            throw new InvalidParameterException("Not same size");

    }
}
