package com.expense.application.tracker.models;

public class BudgetSetup {
    private Long id;
    private String name;
    private BudgetType budgetType;
}

enum BudgetType {
    DAY,
    WEEK,
    MONTH,
    YEAR
}
