package com.epam.cashier;

public interface BankEmittent {
    TransactionStatus withdrawCash(TransactionInformation transactionInformation);

    BalanceInfo getAccountBalance(Card currentCard);
}
