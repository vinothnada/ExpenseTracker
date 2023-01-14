package com.expense.application.Controller;

public class CustomExceptionController extends Exception {
    public CustomExceptionController(String errorMessage) {
        super(errorMessage);
    }
}