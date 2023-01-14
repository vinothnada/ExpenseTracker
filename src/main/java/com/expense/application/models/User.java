package com.expense.application.models;

/**
 * User Class represents a user
 */
public class User {

    private String userName;
    private int userId;

    /**
     * User constructor
     */
    public User(String userName) {
        this.userId = 1;
        this.userName = userName;
    }

    /**
     * User constructor
     */
    public User(int userId, String userName) {
        this.userId = userId;
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
    public int getId() {
        return userId;
    }

    /**
     * setUserId method
     */
    public void setId(int userId) {
        this.userId = userId;
    }
}
