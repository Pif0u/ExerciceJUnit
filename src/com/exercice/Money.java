package com.exercice;

public class Money {
    private int fAmount;
    private String fCurrency;

    public Money(int amount, String currency) {
        this.fAmount = amount;
        this.fCurrency = currency;
    }

    public int getAmount() {
        return fAmount;
    }

    public String getCurrency() {
        return fCurrency;
    }

    public Money add(Money m) {
        return new Money(getAmount()+m.getAmount(), getCurrency());
    }




}
