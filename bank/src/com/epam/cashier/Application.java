package com.epam.cashier;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        byte[] cardNumber = new byte[] {1, 1, 1, 1};
        byte[] pinCode = new byte[] {1, 1, 1, 1};
        Card card = new Card(cardNumber, pinCode);
        CashierMachine cashierMachineOnMostovayaStreet = new CashierMachine();

        byte[] providedPinCode = new byte[] {1, 1, 1, 1};
        cashierMachineOnMostovayaStreet.acceptCard(card, providedPinCode);
        cashierMachineOnMostovayaStreet.withdrawCash(500, CashType.USD);
        cashierMachineOnMostovayaStreet.retrieveAccountBalance();
        cashierMachineOnMostovayaStreet.returnCard();
    }
}
