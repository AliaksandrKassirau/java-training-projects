package com.epam.cashier.bank;

import com.epam.cashier.core.PaymentSystemType;

public class Card {
    public static final String BY_001 = "BY001";
    private final byte[] cardNumber;
    private final PaymentSystemType paymentSystemType;
    private final String serviceCode;
    private byte[] pinCode;

    private Card(byte[] cardNumber,
                PaymentSystemType paymentSystemType,
                String serviceCode,
                byte[] pinCode) {
        this.cardNumber = cardNumber;
        this.paymentSystemType = paymentSystemType;
        this.serviceCode = serviceCode;
        this.pinCode = pinCode;
    }


    public byte[] getPinCode() {
        return pinCode;
    }

    public void changePinCode(byte[] pinCode) {
        this.pinCode = pinCode;
    }

    public byte[] getCardNumber() {
        return cardNumber;
    }

    public static Card provisionCard(PaymentSystemType paymentSystemType) {
        byte[] cardNumber = new byte[] {
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1
        };
        byte[] pinCode = new byte[] {
                1, 1, 1, 1
        };
        return new Card(cardNumber, paymentSystemType, BY_001, pinCode);
    }

    public PaymentSystemType getPaymentSystemType() {
        return paymentSystemType;
    }

    public String getServiceCode() {
        return serviceCode;
    }
}
