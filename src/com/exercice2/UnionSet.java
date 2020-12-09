package com.exercice2;

import java.util.Vector;

public class UnionSet {
    private Vector v1;
    private Vector v2;

    /**
     *
     * Cette fonction fusionne deux vecteur en un nouveau vecteur
     * Le nouveau vecteur est généré dans l'ordre des paramètres v1 puis v2
     *
     * @param v1 Un vector non vide
     * @param v2 Un vector non vide
     * @return un nouveau Vector
     */
    public static Vector<Object> unionSet(Vector<Object> v1, Vector<Object> v2) {

        try {
            Vector<Object> result = new Vector<Object>();
            result.addAll(v1);
            result.addAll(v2);
            return result;
        } catch (NullPointerException e) {
            return new Vector<>();
        }
    }
}
