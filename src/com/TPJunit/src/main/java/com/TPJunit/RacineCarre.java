package com.TPJunit;


import java.util.Hashtable;

public class RacineCarre {


    public static Hashtable<Integer, Double> racineCarre(Integer v1, Integer v2) {

        /**
         * On vérifie si les deux paramètres sont des nombres positif ou nul
         */
        if(v1 < 0 || v2 < 0) {
            throw new IllegalArgumentException("Erreur : Nombre nulle ou positive seulement");
        }

        /**
         * On vérifie si v1 < v2
         */
        if (v1 > v2) {
            throw new IllegalArgumentException("Erreur : premiere paramètre plus grand que le deuxième paramètre");
        }

        Integer debut = v1;
        Integer fin = v2;


        Hashtable<Integer, Double> result = new Hashtable<>();

        for (int i = debut; i <= fin; i++) {
            result.put(i, Math.sqrt(i));
        }

        return result;
    }

}
