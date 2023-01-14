package com.expense.application.utils;

public class CustomExceptions extends Exception {
    public CustomExceptions(String errorMessage) {
        super(errorMessage);
    }
}