package com.epam.cashier;

public class Card {
    private byte[] cardNumber;
    private byte[] pinCode;

    public Card(byte[] cardNumber,
                byte[] pinCode) {
        this.cardNumber = cardNumber;
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
}
