package com.expense.application.models;

import com.expense.application.models.enums.TransactionType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private int id;
    private Category category;
    private double amount;
    private TransactionType transactionType;
    private Date transactionDate;

    public Transaction() {
    }

    public Transaction(Category category, double amount, TransactionType transactionType, Date transactionDate) {
        this.category = category;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
    }

    public Transaction(int id, Category category, double amount, TransactionType transactionType,
            Date transactionDate) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "Transaction ID: " + id + " | " + "Amount: " + amount + " | " + "Category: " + category.getName() + " | "
                + "Type: " + transactionType + " | " + "Date: " + formatter.format(transactionDate);
    }

}
