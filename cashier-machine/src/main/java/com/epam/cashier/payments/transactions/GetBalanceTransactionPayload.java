package com.epam.cashier.payments.transactions;

import com.epam.cashier.core.CashType;

public class GetBalanceTransactionPayload {
    private final byte[] cardNumber;
    private final String serviceCode;
    private final CashType cashType;

    public GetBalanceTransactionPayload(byte[] cardNumber, String serviceCode, CashType cashType) {
        this.cardNumber = cardNumber;
        this.serviceCode = serviceCode;
        this.cashType = cashType;
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
}
