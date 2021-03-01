package com.epam.cashier.payments;

public class TransactionStatus {
    private Status status;
    private String message;

    public TransactionStatus(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Status getStatus() {
        return status;
    }


    public enum Status {
        APPROVED,
        REJECTED,
        NOT_ENOUGH_MONEY
    }
}
