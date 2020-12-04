package com.exercice2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UnionSetTest {

    private Vector v1;
    private Vector v2;
    private Vector unionVector;

    @BeforeAll
    void setUp() {

        v1 = new Vector<>();
        v2 = new Vector<>();
        unionVector = new Vector<>();

        v1.addElement(1);
        v1.addElement(2);
        v1.addElement(3);
        v1.addElement(4);
        v1.addElement(5);

        v2.addElement(6);
        v2.addElement(7);
        v2.addElement(8);
        v2.addElement(9);
        v2.addElement(10);

        unionVector = UnionSet.unionSet(v1, v2);

    }

    @AfterAll
    public void tearDown(){
        v1 = null;
        v2 = null;
        unionVector = null;
    }

    @Test
    void testElementAt() {
        for (int i = 1 ; i <= unionVector.size() ; i++) {
            Integer chiffre = (Integer)unionVector.elementAt(i-1);
            System.out.println("Valeur Vecteur: " + chiffre + " Valeur i: " + i);
            assertTrue(chiffre.intValue() == i);
        }

    }
}