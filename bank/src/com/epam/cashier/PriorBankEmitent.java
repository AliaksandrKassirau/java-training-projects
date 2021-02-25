package com.epam.cashier;

public class PriorBankEmitent implements BankEmittent {

    @Override
    public TransactionStatus withdrawCash(TransactionInformation transactionInformation) {
        return TransactionStatus.APPROVED;
    }

    @Override
    public BalanceInfo getAccountBalance(Card currentCard) {
        return new BalanceInfo(1000, CashType.USD);
    }
}
