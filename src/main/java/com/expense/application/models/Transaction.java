package com.expense.application.models;

public class Transaction {
    private int id;
    private User user;
    private Category category;
    private double amount;
    private TransactionType transactionType;

    public Transaction() {
    }

    public Transaction(int id, User user, Category category, double amount, TransactionType transactionType) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}

enum TransactionType {
    INCOME,
    EXPENSE
}
