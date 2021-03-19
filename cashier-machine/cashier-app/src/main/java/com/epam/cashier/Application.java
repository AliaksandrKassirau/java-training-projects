package com.epam.cashier;

import com.epam.cashier.atm.CashierMachine;
import com.epam.cashier.bank.Card;
import com.epam.cashier.core.CashType;
import com.epam.cashier.core.PaymentSystemType;
import com.epam.cashier.payments.MasterCardPaymentSystemService;
import com.epam.cashier.payments.PaymentSystemService;
import com.epam.cashier.payments.VisaPaymentSystemService;
import com.epam.cashier.payments.banks.BankService;
import com.epam.cashier.payments.banks.InMemoryBankService;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import static com.epam.cashier.bank.Card.BY_001;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        Map<String, BankService> banksRegistryByServiceCode = new HashMap<>();
        banksRegistryByServiceCode.put(BY_001, new InMemoryBankService());

        Map<PaymentSystemType, PaymentSystemService> supportedPaymentSystems = new EnumMap<>(PaymentSystemType.class);
        supportedPaymentSystems.put(PaymentSystemType.VISA, new VisaPaymentSystemService(banksRegistryByServiceCode));
        supportedPaymentSystems.put(PaymentSystemType.MASTER_CARD, new MasterCardPaymentSystemService());

        Card card = Card.provisionCard(PaymentSystemType.VISA);
        CashierMachine cashierMachineOnMostovayaStreet = new CashierMachine(supportedPaymentSystems);

        byte[] providedPinCode = new byte[] { 1, 1, 1, 1 };
        cashierMachineOnMostovayaStreet.acceptCard(card, providedPinCode);
        cashierMachineOnMostovayaStreet.withdrawCash(500, CashType.USD);
        cashierMachineOnMostovayaStreet.retrieveAccountBalance();

        cashierMachineOnMostovayaStreet.withdrawCash(50, CashType.USD);
        cashierMachineOnMostovayaStreet.retrieveAccountBalance();
        cashierMachineOnMostovayaStreet.returnCard();
    }
}
