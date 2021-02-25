package com.epam.cashier;

public class BalanceInfo {
    private double amount;
    private CashType cashType;

    public BalanceInfo(double amount, CashType cashType) {
        this.amount = amount;
        this.cashType = cashType;
    }

    public double getAmount() {
        return amount;
    }

    public CashType getCashType() {
        return cashType;
    }

    @Override
    public String toString() {
        return amount + " " + cashType.name();
    }
}
