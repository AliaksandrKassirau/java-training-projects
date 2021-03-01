package com.epam.cashier.payments.banks;

import com.epam.cashier.bank.Account;
import com.epam.cashier.bank.Transaction;
import com.epam.cashier.core.CashType;
import com.epam.cashier.payments.BalanceInfo;
import com.epam.cashier.payments.TransactionStatus;
import com.epam.cashier.payments.transactions.WithdrawalTransactionPayload;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InMemoryBankService implements BankService {
    private Map<CardWrapper, Account> accounts;

    public InMemoryBankService() {
        initAccounts();
    }

    @Override
    public TransactionStatus processTransaction(WithdrawalTransactionPayload payload) {
        Account account = accounts.get(new CardWrapper(payload.getCardNumber()));
        if (account.getCurrentBalance().doubleValue() < payload.getAmount()) {
            return new TransactionStatus(TransactionStatus.Status.REJECTED, "Недостаточно средст");
        }

        account.addTransaction(new Transaction(payload.getAmount() * -1));
        return new TransactionStatus(TransactionStatus.Status.APPROVED, "Все успешно");
    }

    @Override
    public BalanceInfo getBalanceInfo(byte[] cardNumber) {
        Account account = accounts.get(new CardWrapper(cardNumber));
        return new BalanceInfo(account.getCurrentBalance().doubleValue(), CashType.USD);
    }


    private void initAccounts() {
        this.accounts = new HashMap<>();
        this.accounts.put(new CardWrapper(new byte[] {
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1
        }),
                new Account()
                        .addTransaction(new Transaction(100))
                        .addTransaction(new Transaction(150))
                        .addTransaction(new Transaction(-10))
        );
    }

    class CardWrapper {
        private byte[] cardNumber;

        public CardWrapper(byte[] cardNumber) {
            this.cardNumber = cardNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CardWrapper that = (CardWrapper) o;
            return Arrays.equals(cardNumber, that.cardNumber);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(cardNumber);
        }
    }
}
