package com.expense.application.models;

public class Category {
    private int id;
    private String name;
    private String description;

    private boolean isRecurring;

    private int recurrenceDays = 0;

    public Category() {
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Category(int id, String name, String description, boolean isRecurring, int recurrenceDays) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isRecurring = isRecurring;
        this.recurrenceDays = recurrenceDays;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public void setRecurring(boolean recurring) {
        isRecurring = recurring;
    }

    public int getRecurrenceDays() {
        return recurrenceDays;
    }

    public void setRecurrenceDays(int recurrenceDays) {
        this.recurrenceDays = recurrenceDays;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category ID: " + id + " | " + "Name: " + name + " | " + "Description: " + description;
    }    
}
