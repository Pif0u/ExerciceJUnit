package com.exercice2;

import java.util.Vector;

public class UnionSet {
    private Vector v1;
    private Vector v2;

    public static Vector<Object> unionSet(Vector<Object> v1, Vector<Object> v2) {
        Vector<Object> result = new Vector<Object>();
        result.addAll(v1);
        result.addAll(v2);
        return result;
    }

}
