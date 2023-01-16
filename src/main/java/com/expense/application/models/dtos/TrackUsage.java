package com.expense.application.models.dtos;

public class TrackUsage {
    private String category;
    private double budget;
    private double income = 0;
    private double expense = 0;
    private double budgetPercentage;
    private String dateBetween;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public double getBudgetPercentage() {
        return budgetPercentage;
    }

    public void setBudgetPercentage(double budgetPercentage) {
        this.budgetPercentage = budgetPercentage;
    }

    public String getDateBetween() {
        return dateBetween;
    }

    public void setDateBetween(String dateBetween) {
        this.dateBetween = dateBetween;
    }
}
