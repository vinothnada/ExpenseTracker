package com.expense.application.tracker.models;

public class Transaction {
    private Long id;
    private User user;
    private Category category;
    private double amount;
    private TransactionType transactionType;

}

enum TransactionType {
    INCOME,
    EXPENSE
}
