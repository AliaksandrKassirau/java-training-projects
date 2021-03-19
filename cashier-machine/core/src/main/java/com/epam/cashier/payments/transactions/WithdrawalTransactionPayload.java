package com.epam.cashier.payments.transactions;

import com.epam.cashier.core.CashType;

public class WithdrawalTransactionPayload {
    private final byte[] cardNumber;
    private final String serviceCode;
    private final CashType cashType;
    private final double amount;
    // private String cashierMachineCode; do we really need this parameter?


    public WithdrawalTransactionPayload(byte[] cardNumber, String serviceCode, CashType cashType, double amount) {
        this.cardNumber = cardNumber;
        this.serviceCode = serviceCode;
        this.cashType = cashType;
        this.amount = amount;
    }

    public byte[] getCardNumber() {
        return cardNumber;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public CashType getCashType() {
        return cashType;
    }

    public double getAmount() {
        return amount;
    }
}
