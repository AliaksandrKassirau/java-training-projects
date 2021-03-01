package com.epam.cashier;

import com.epam.cashier.atm.CashierMachine;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        byte[] cardNumber = new byte[] {1, 1, 1, 1};
        byte[] pinCode = new byte[] {1, 1, 1, 1};
        Card card = new Card(cardNumber, pinCode);
        CashierMachine cashierMachineOnMostovayaStreet = new CashierMachine();

        byte[] providedPinCode = new byte[] {1, 1, 1, 1};
        cashierMachineOnMostovayaStreet.acceptCard(card, providedPinCode);
        cashierMachineOnMostovayaStreet.withdrawCash(500, CashType.USD);
        cashierMachineOnMostovayaStreet.retrieveAccountBalance();
        cashierMachineOnMostovayaStreet.returnCard();
        List<CashierMachine> cashierMachines = new ArrayList<>();
        while(true) {
            CashierMachine cashierMachine = new CashierMachine();
            cashierMachine.acceptCard(card, providedPinCode);
            cashierMachine.withdrawCash(500, CashType.USD);
            cashierMachine.retrieveAccountBalance();
            cashierMachines.add(cashierMachine);
            Thread.sleep(1);
        }
    }
}
