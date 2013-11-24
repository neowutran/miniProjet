package model;

import model.personne.Emprunteur;

import java.security.InvalidParameterException;
import java.util.Calendar;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Finder.
 */
public class Finder {

    /**
     * Find materiel.
     *
     * @param findMateriel the find materiel
     * @return the materiel
     */
    public static Materiel findMateriel(Materiel findMateriel) {

        List<Materiel> materiels = Inventaire.getMateriel();
        for (Materiel materiel : materiels) {
            if (materiel.equals(findMateriel))
                return materiel;
        }

        return null;

    }

    /**
     * Find exactly.
     *
     * @param findMateriel the find materiel
     * @return the integer
     */
    public static Integer findExactly(Materiel findMateriel) {
    
        List<Materiel> materiels = Inventaire.getMateriel();
        for (Materiel materiel : materiels) {
    
            if (materiel.equals(findMateriel)) {
                return materiel.getQuantity();
            }
    
        }
    
        return 0;
    
    }

    /**
     * Find exactly.
     *
     * @param findMateriel the find materiel
     * @param debut the debut
     * @param fin the fin
     * @return the integer
     * @throws InvalidParameterException the invalid parameter exception
     */
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

    /**
     * Find exactly avaiable.
     *
     * @param findMateriel the find materiel
     * @param debut the debut
     * @param fin the fin
     * @return the integer
     */
    public static Integer findExactlyAvaiable(Materiel findMateriel, Calendar debut, Calendar fin) {

        return findExactly(findMateriel) - findExactly(findMateriel, debut, fin);

    }

    /**
     * Find.
     *
     * @param caracteristique the caracteristique
     * @param operateur the operateur
     * @param value the value
     * @return true, if successful
     * @throws Exception the exception
     */
    public static boolean find(List<Caracteristique> caracteristique, List<String> operateur, List<Object> value) throws Exception {

        checkSize(caracteristique, operateur, value);

        //TODO
        return false;
    }

    /**
     * Check size.
     *
     * @param caracteristiques the caracteristiques
     * @param operateur the operateur
     * @param value the value
     * @throws InvalidParameterException the invalid parameter exception
     */
    private static void checkSize(List<Caracteristique> caracteristiques, List<String> operateur, List<Object> value) throws InvalidParameterException {

        if (caracteristiques.size() != operateur.size() || operateur.size() != value.size())
            throw new InvalidParameterException("Not same size");

    }
}
