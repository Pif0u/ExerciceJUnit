package com.TPJunit;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RacineCarreTest {

    @AfterAll
    public void tearDown(){

    }

    @Test
    void testExceptionNombreNegatif() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            RacineCarre.racineCarre(-10, 5);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            RacineCarre.racineCarre(-10, -5);
        });
    }

    @Test
    void testExceptionOrdreIntervalle() {
        // Bon ordre
        RacineCarre.racineCarre(5, 10);

        // Mauvais ordre
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            RacineCarre.racineCarre(10, 5);
        });
    }

    @Test
    void testValeursCorrectes() {
        Hashtable tableau = RacineCarre.racineCarre(1,100);

        /**
         * Expected = résultat de la raciné carré
         * Actual = On récupére dans le tableau le résultat de la racine carré d'un nombre
         */
        assertEquals(3.0, tableau.get(9));
        assertEquals(5.0, tableau.get(25));
        assertEquals(9.0, tableau.get(81));
        assertEquals(10.0, tableau.get(100));
    }

    @Test
    void testTempsExecution() {
        // Si l'execution prend plus de 5 secondes, erreur
        assertTimeoutPreemptively(Duration.ofMillis(5000), () -> {
            Hashtable tableau = RacineCarre.racineCarre(1,10000);
        });
    }
}