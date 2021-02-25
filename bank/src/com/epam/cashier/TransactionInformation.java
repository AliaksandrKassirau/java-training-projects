package com.epam.cashier;

public class TransactionInformation {
    private final double amount;
    private final CashType cashType;
    private final byte[] cardNumber;

    public TransactionInformation(double amount, CashType cashType, byte[] cardNumber) {
        this.amount = amount;
        this.cashType = cashType;
        this.cardNumber = cardNumber;
    }

    public double getAmount() {
        return amount;
    }

    public CashType getCashType() {
        return cashType;
    }

    public byte[] getCardNumber() {
        return cardNumber;
    }
}
