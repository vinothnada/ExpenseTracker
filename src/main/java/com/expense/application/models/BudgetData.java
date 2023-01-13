package com.expense.application.models;

public class BudgetData {
    private int id;
    private BudgetSetup budgetSetup;
    private Category category;
    private double amount;

    public BudgetData() {
    }

    public BudgetData(BudgetSetup budgetSetup, Category category, double amount) {
        this.budgetSetup = budgetSetup;
        this.category = category;
        this.amount = amount;
    }

    public BudgetData(int id, BudgetSetup budgetSetup, Category category, double amount) {
        this.id = id;
        this.budgetSetup = budgetSetup;
        this.category = category;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BudgetSetup getBudgetSetup() {
        return budgetSetup;
    }

    public void setBudgetSetup(BudgetSetup budgetSetup) {
        this.budgetSetup = budgetSetup;
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
}
