package com.epam.cashier.payments.banks;

import com.epam.cashier.payments.BalanceInfo;
import com.epam.cashier.payments.TransactionStatus;
import com.epam.cashier.payments.transactions.WithdrawalTransactionPayload;

public interface BankService {

    TransactionStatus processTransaction(WithdrawalTransactionPayload payload);

    BalanceInfo getBalanceInfo(byte[] cardNumber);

}
