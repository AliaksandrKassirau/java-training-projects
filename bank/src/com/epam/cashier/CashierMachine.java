package com.epam.cashier;

import java.util.Arrays;
import java.util.Objects;

public class CashierMachine {
    private Card currentCard;
    private BankEmittent currentBankEmittent;
    private BankEmittentRegistry emittentRegistry;


    public void acceptCard(Card providedCard, byte[] providedPinCode) {
        Objects.requireNonNull(providedPinCode, "Пин-код не предоставлен");
        Objects.requireNonNull(providedCard, "Карта не предоставлена");

        if (currentCard != null) {
            System.out.println("Банкомат уже занят обработкой другой карты");
            return;
        }

        currentCard = providedCard;

        verifyPinCode(providedPinCode);
    }

    private void verifyPinCode(byte[] providedPinCode) {
        currentBankEmittent = resolveBankSystemByCurrentCard();
        if ( !Arrays.equals(currentCard.getPinCode(), providedPinCode) ) {
            System.out.println("Введенный пин-код не верный");
        }
    }

    private BankEmittent resolveBankSystemByCurrentCard() {
        return new PriorBankEmitent();
    }

    public void withdrawCash(double amount, CashType cashType) {
        TransactionStatus transactionStatus = currentBankEmittent.withdrawCash(new TransactionInformation(amount, cashType, currentCard.getCardNumber()));
        if (TransactionStatus.APPROVED.equals(transactionStatus)) {
            System.out.println("Выдать деньги банкоматом");
        }
    }

    public void retrieveAccountBalance() {
        BalanceInfo accountBalance = currentBankEmittent.getAccountBalance(currentCard);
        System.out.println(accountBalance);
    }

    public void returnCard() {
        currentCard = null;
        currentBankEmittent = null;
    }
}
