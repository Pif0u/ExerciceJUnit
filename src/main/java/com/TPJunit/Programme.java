package com.TPJunit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class Programme {
    public static void main(String[] args) {
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));


        try {
            System.out.print("Nombre a :");
            int a = Integer.parseInt(br1.readLine());
            System.out.print("Nombre b :");
            int b = Integer.parseInt(br2.readLine());

            Hashtable result = RacineCarre.racineCarre(a, b);

            result.forEach((k, v) ->
            {
                System.out.println("Nombre : " + k + " / Racine carré : " + v);
            });

        } catch(NumberFormatException e1) {
            throw new IllegalArgumentException("Erreur : Nombre nul ou positif seulement");
        } catch (IOException e2) {
            e2.printStackTrace();
        }

    }
}
