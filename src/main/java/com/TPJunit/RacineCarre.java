package com.TPJunit;


import java.util.Hashtable;

public class RacineCarre {


    /**
     * Fonction qui permet de calculer les racines carrées dans un intervalle donné
     * @param v1 intervalle de début de calcul des racines carrées
     * @param v2 intervalle de fin de calcul des racines carrées
     * @return Hashtable (tableau clé/valeur) avec comme clé un nombre et comme
     *          valeur la racine carré de ce nombre
     */
    public static Hashtable<Integer, Double> racineCarre(Integer v1, Integer v2) {

        /**
         * On vérifie si les deux paramètres sont des nombres positif ou nul
         */
        if(v1 < 0 || v2 < 0) {
            throw new IllegalArgumentException("Erreur : Nombre nul ou positif seulement");
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
