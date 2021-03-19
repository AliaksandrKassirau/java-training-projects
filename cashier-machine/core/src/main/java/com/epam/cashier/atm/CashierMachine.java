package com.epam.cashier.atm;

import com.epam.cashier.bank.Card;
import com.epam.cashier.core.CashType;
import com.epam.cashier.core.PaymentSystemType;
import com.epam.cashier.payments.*;
import com.epam.cashier.payments.transactions.GetBalanceTransactionPayload;
import com.epam.cashier.payments.transactions.WithdrawalTransactionPayload;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class CashierMachine {
    private Map<PaymentSystemType, PaymentSystemService> supportedPaymentSystems;
    private Card currentCard;

    public CashierMachine(Map<PaymentSystemType, PaymentSystemService> supportedPaymentSystems) {
        this.supportedPaymentSystems = supportedPaymentSystems;
    }

    public void acceptCard(Card providedCard, byte[] providedPinCode) {
        Objects.requireNonNull(providedPinCode, "Пин-код не предоставлен");
        Objects.requireNonNull(providedCard, "Карта не предоставлена");

        if (!supportedPaymentSystems.containsKey(providedCard.getPaymentSystemType())) {
            System.out.println(String.format("Система %s не поддерживается", providedCard.getPaymentSystemType().name()));
            returnCard();
        }


        if (currentCard != null) {
            System.out.println("Банкомат уже занят обработкой другой карты");
            return;
        }

        currentCard = providedCard;

        verifyPinCode(providedPinCode);
    }

    private void verifyPinCode(byte[] providedPinCode) {
        //currentBankEmittent = resolveBankSystemByCurrentCard();
        if ( !Arrays.equals(currentCard.getPinCode(), providedPinCode) ) {
            System.out.println("Введенный пин-код не верный");
        }
    }

    public void withdrawCash(double amount, CashType cashType) {
        PaymentSystemService paymentSystemService = supportedPaymentSystems.get(currentCard.getPaymentSystemType());
        WithdrawalTransactionPayload payload = new WithdrawalTransactionPayload(currentCard.getCardNumber(), currentCard.getServiceCode()
                , cashType,  amount);
        TransactionStatus transactionStatus = paymentSystemService.processTransaction(payload);

        if (TransactionStatus.Status.APPROVED.equals(transactionStatus.getStatus())) {
            System.out.println("Выдать деньги банкоматом");
        } else {
            System.out.println(transactionStatus.getMessage());
        }
    }

    public void retrieveAccountBalance() {
        PaymentSystemService paymentSystemService = supportedPaymentSystems.get(currentCard.getPaymentSystemType());
        GetBalanceTransactionPayload payload = new GetBalanceTransactionPayload(currentCard.getCardNumber(),
                currentCard.getServiceCode(), CashType.BYN);
        BalanceInfo accountBalance = paymentSystemService.getBalanceInfo(payload);
        System.out.println(accountBalance);
    }

    public void returnCard() {
        currentCard = null;
    }
}
