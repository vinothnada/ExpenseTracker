package com.expense.application.models;

import com.expense.application.models.enums.BudgetType;

public class BudgetSetup {
    private int id;
    private String name;
    private BudgetType budgetType;

    public BudgetSetup() {
    }

    public BudgetSetup( String name, BudgetType budgetType) {
        this.name = name;
        this.budgetType = budgetType;
    }
    public BudgetSetup(int id, String name, BudgetType budgetType) {
        this.id = id;
        this.name = name;
        this.budgetType = budgetType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BudgetType getBudgetType() {
        return budgetType;
    }

    public void setBudgetType(BudgetType budgetType) {
        this.budgetType = budgetType;
    }
}

