package com.exercice;

import java.util.ArrayList;

public class MoneyBag {
    private ArrayList<Money> Bag = new ArrayList<>();

    public ArrayList<Money> getBag() {
        return this.Bag;
    }

    public Money normalise(Money m) {
        if (this.Bag != null && this.Bag.size() > 0) {
            Money first = this.Bag.get(0);

            if(!first.getCurrency().equals(m.getCurrency())) {
                if (first.getCurrency().equals("EUR") && m.getCurrency().equals("USD")) {
                    return new Money((int) (m.getAmount() * 0.821713), "EUR");
                } else if (first.getCurrency().equals("EUR") && m.getCurrency().equals("GBP")) {
                    return new Money((int) (m.getAmount() * 1.10785), "EUR");
                } else if (first.getCurrency().equals("USD") && m.getCurrency().equals("EUR")) {
                    return new Money((int) (m.getAmount() * 1.1669), "USD");
                } else if (first.getCurrency().equals("USD") && m.getCurrency().equals("GBP")) {
                    return new Money((int) (m.getAmount() * 1.34794), "USD");
                } else if (first.getCurrency().equals("GBP") && m.getCurrency().equals("EUR")) {
                    return new Money((int) (m.getAmount() * 0.902786), "GBP");
                } else if (first.getCurrency().equals("GBP") && m.getCurrency().equals("USD")) {
                    return new Money((int) (m.getAmount() * 0.742069), "GBP");
                }
            }
        }
        return m;
    }

    public boolean equalMoney(Money m1, Money m2) {
        return (m1.getAmount() == m2.getAmount() && m1.getCurrency() == m2.getCurrency());
    }

    public void add(Money m) {
        this.Bag.add(m);
    }

    public void sub(Money m) {
        for(int i = 0 ; i < this.Bag.size() ; ++i) {
            if(this.equalMoney(this.Bag.get(i), m)) {
                this.Bag.remove(i);
            }
        }
    }

}




