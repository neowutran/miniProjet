package model;

import java.security.*;
import java.util.*;

/**
 * Created by draragar on 17/11/13.
 */
public class Finder {

    public static boolean find(List<ICaracteristique> caracteristique, List<String> operateur, List<Object> value) throws Exception {

        checkSize(caracteristique, operateur,value);

        //TODO
        return false;
    }

    private static void checkSize(List<ICaracteristique> caracteristiques, List<String> operateur, List<Object> value ) throws InvalidParameterException{

        if(caracteristiques.size() != operateur.size() || operateur.size() != value.size()) throw new InvalidParameterException("Not same size");

    }
}
