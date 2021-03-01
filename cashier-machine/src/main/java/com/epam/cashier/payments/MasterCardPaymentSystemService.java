package com.epam.cashier.payments;

import com.epam.cashier.payments.transactions.GetBalanceTransactionPayload;
import com.epam.cashier.payments.transactions.WithdrawalTransactionPayload;

public class MasterCardPaymentSystemService implements PaymentSystemService {

    @Override
    public TransactionStatus processTransaction(WithdrawalTransactionPayload payload) {
        return null;
    }

    @Override
    public BalanceInfo getBalanceInfo(GetBalanceTransactionPayload payload) {
        return null;
    }
}
