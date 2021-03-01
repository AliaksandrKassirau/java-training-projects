package com.epam.cashier.payments;

import com.epam.cashier.payments.transactions.GetBalanceTransactionPayload;
import com.epam.cashier.payments.transactions.WithdrawalTransactionPayload;

public interface PaymentSystemService {

    TransactionStatus processTransaction(WithdrawalTransactionPayload payload);

    BalanceInfo getBalanceInfo(GetBalanceTransactionPayload payload);
}
