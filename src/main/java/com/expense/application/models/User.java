package com.expense.application.models;

import java.util.UUID;

/**
 * User Class represents a user
 */
public class User {

    private String userName;
    private final String userId;
    /**
     * User constructor
     */
    public User(String userName){
        this.userId = String.valueOf(UUID.randomUUID());
        this.userName = userName;
    }
    /**
     * getUserName method
     */
    public String getUserName() {
        return userName;
    }
    /**
     * setUserName method
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * getUserId method
     */
    public String getUserId() {
        return userId;
    }
}
