package com.emmutua.cashcard.entity;

public class CashCard {
    private Long id;
    private Double amount;
    public CashCard(Long id, Double v) {
        this.id = id;
        this.amount = v;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
