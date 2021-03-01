package com.epam.cashier.payments;

import com.epam.cashier.payments.banks.BankService;
import com.epam.cashier.payments.transactions.GetBalanceTransactionPayload;
import com.epam.cashier.payments.transactions.WithdrawalTransactionPayload;

import java.util.Map;

public class VisaPaymentSystemService implements PaymentSystemService {
    private Map<String, BankService> banksRegistry;

    public VisaPaymentSystemService(Map<String, BankService> banksRegistry) {
        this.banksRegistry = banksRegistry;
    }


    @Override
    public TransactionStatus processTransaction(WithdrawalTransactionPayload payload) {
        BankService bankService = banksRegistry.get(payload.getServiceCode());
        return bankService.processTransaction(payload);
    }

    @Override
    public BalanceInfo getBalanceInfo(GetBalanceTransactionPayload payload) {
        BankService bankService = banksRegistry.get(payload.getServiceCode());
        return bankService.getBalanceInfo(payload.getCardNumber());
    }
}
