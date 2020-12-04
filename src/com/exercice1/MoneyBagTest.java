package com.exercice1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MoneyBagTest {

    @Test
    void equalMoney() {
        Money m1 = new Money(10, "EUR");
        Money m2 = new Money(10, "EUR");
        Money m3 = new Money(15, "EUR");
        Money m4 = new Money(10, "USD");

        MoneyBag moneyBag = new MoneyBag();
        assertTrue(moneyBag.equalMoney(m1, m2));
        assertFalse(moneyBag.equalMoney(m1, m3));
        assertFalse(moneyBag.equalMoney(m1, m4));
        assertFalse(moneyBag.equalMoney(m2, m3));
        assertFalse(moneyBag.equalMoney(m2, m4));

    }

    @Test
    void add() {
        MoneyBag moneyBag = new MoneyBag();
        // TEST LISTE VIDE
        assertEquals(0, moneyBag.getBag().size());

        // TEST AJOUT ELEMENT
        moneyBag.add(new Money(10, "EUR"));
        ArrayList<Money> list = moneyBag.getBag();
        Money item1 = list.get(0);
        assertEquals(item1.getAmount(), 10);
        assertEquals(item1.getCurrency(), "EUR");
    }

    @Test
    void sub() {
        MoneyBag moneyBag = new MoneyBag();
        // TEST LISTE VIDE
        assertEquals(0, moneyBag.getBag().size());

        // AJOUT ELEMENT
        moneyBag.add(new Money(10, "EUR"));

        // VERIRICATION SI C'EST LE SEUL ELEMENT DU TABLEAU
        assertEquals(moneyBag.getBag().size(), 1);

        // VERIFICATION SI L'ELEMENT DU TABLEAU N'EST PAS ENLEVE
        moneyBag.sub(new Money(30, "EUR"));
        assertEquals(moneyBag.getBag().size(), 1);

        moneyBag.sub(new Money(15, "USD"));
        assertEquals(moneyBag.getBag().size(), 1);

        moneyBag.sub(new Money(5, "GBP"));
        assertEquals(moneyBag.getBag().size(), 1);

        // TEST SUPPRESION ELEMENT DANS LA LISTE
        moneyBag.sub(new Money(10, "EUR"));
        assertEquals(moneyBag.getBag().size(), 0);

    }

    @Test
    void normalize() {
        Money m1 = new Money(10, "EUR");
        Money m2 = new Money(10, "EUR");
        Money m3 = new Money(20, "USD");
        Money m4 = new Money(5, "EUR");

        MoneyBag moneyBag = new MoneyBag();
        moneyBag.add(m1);

        // identique
        assertTrue(moneyBag.equalMoney(moneyBag.normalise(m2), m2));

        // identique
        assertTrue(moneyBag.equalMoney(moneyBag.normalise(m2), m1));


        // CONVERTION DOLLARS EURO
        assertTrue(moneyBag.equalMoney(moneyBag.normalise(m3), new Money(16, "EUR")));

    }
}