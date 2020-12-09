package com.TPJunit;

import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {

        Hashtable result = RacineCarre.racineCarre(5,100);

        result.forEach((k, v) ->
        {
           System.out.println("Nombre : " + k + " / Racine carré : " + v);
        });


    }
}
