package com.epam.cashier.bank;

import com.epam.cashier.core.CashType;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Account {
    private CashType cashType;
    private List<Transaction> transactions = new LinkedList<>();

    public Account addTransaction(Transaction transaction) {
        transactions.add(transaction);
        return this;
    }

    public BigDecimal getCurrentBalance() {
        BigDecimal balance = new BigDecimal(0);
        for (Transaction transaction: transactions) {
            balance = balance.add(new BigDecimal(transaction.getAmount()));
        }
        return balance;
    }
}
