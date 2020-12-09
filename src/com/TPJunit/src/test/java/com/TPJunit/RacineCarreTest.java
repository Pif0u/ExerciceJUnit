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
    @DisplayName("Nombres négatifs")
    void testExceptionNombreNegatif() {
        assertThrows(IllegalArgumentException.class, () -> {
            RacineCarre.racineCarre(-10, 5);
        },"A négatif mais la fonction ne renvoie pas IllegalArgumentException");
        assertThrows(IllegalArgumentException.class, () -> {
            RacineCarre.racineCarre(10, -5);
        },"b négatif mais la fonction ne renvoie pas IllegalArgumentException");
        assertThrows(IllegalArgumentException.class, () -> {
            RacineCarre.racineCarre(-10, -5);
        },"a et b négatifs mais la fonction ne renvoie pas IllegalArgumentException");
    }

    @Test
    @DisplayName("Mauvais ordre")
    void testExceptionOrdreIntervalle() {
        assertThrows(IllegalArgumentException.class, () -> {
            RacineCarre.racineCarre(10, 5);
        });
    }

    @Test
    @DisplayName("Valeurs attendues")
    void testValeursCorrectes() {
        Hashtable tableau = RacineCarre.racineCarre(1,100);

        /**
         * Expected = résultat de la raciné carré
         * Actual = On récupère dans le tableau le résultat de la racine carré d'un nombre
         */
        assertEquals(3.0, tableau.get(9),"√9 != 3");
        assertEquals(5.0, tableau.get(25),"√25 != 5");
        assertEquals(9.0, tableau.get(81),"√81 != 9");
        assertEquals(10.0, tableau.get(100),"√100 != 10");
    }

    @Test
    @DisplayName("Temps d'exécution")
    void testTempsExecution() {
        // Si l'execution prend plus de 5 secondes, erreur
        assertTimeoutPreemptively(Duration.ofMillis(5000), () -> {
            Hashtable tableau = RacineCarre.racineCarre(1,10000);
        });
    }
}