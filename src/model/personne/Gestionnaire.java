package model.personne;

/**
 * Created by draragar on 17/11/13.
 */
public class Gestionnaire extends model.Personne {

    public void setEtatEmprunt(model.Emprunt emprunt, model.Etat etat) {

        emprunt.setEtat(etat);
        emprunt.setGestionnaire(this);
    }

}
