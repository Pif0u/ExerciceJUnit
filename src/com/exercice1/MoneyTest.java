package com.exercice1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MoneyTest {
    private Money _amount;

    @BeforeAll
    public void setUp(){
        _amount = new Money(0,"EUR");
    }

    @AfterAll
    public void tearDown(){
        _amount = null;
    }

    @org.junit.jupiter.api.Test
    public void testCreate() {
        assertEquals(0, _amount.getAmount());
        assertEquals("EUR", _amount.getCurrency());

        Money amount2 = new Money (10, "USD");

        assertEquals(10, amount2.getAmount());
        assertEquals("USD", amount2.getCurrency());

        Money amount3 = new Money (-4, "EUR");

        assertEquals(-4, amount3.getAmount());
        assertEquals("EUR", amount3.getCurrency());

    }

}