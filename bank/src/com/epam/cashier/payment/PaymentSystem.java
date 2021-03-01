package com.epam.cashier.payment;

public interface PaymentSystem {
    PaymentStatus performPayment(PaymentTransaction paymentTransaction);
}
