package com.expense.application.Controller;

import com.expense.application.models.Transaction;
import com.expense.application.models.User;

import java.io.IOException;

/**
 * Dummy DataBase Controller represents an in memory database created with data structures and algorithms
 */
public class DummyDataBaseController {
    /**
     * DummyDataBaseController private static instance for a singleton connection
     */
    private static DummyDataBaseController dbInstance;

    /**
     * DummyDataBaseController constructor of the {@link DummyDataBaseController} class
     */
    private DummyDataBaseController(){
    }
    /**
     * getInstance method of the {@link DummyDataBaseController} class
     */
    public static DummyDataBaseController getInstance() throws IOException {
        if (dbInstance == null)
        {
            ConfigReader reader = new ConfigReader("settings.properties");
            String appName = reader.getProperty("application.name");
            dbInstance = new  DummyDataBaseController();
        }
        return dbInstance;
    }
    /**
     * insert Transaction method of the {@link DummyDataBaseController} class
     */
    public static boolean insert(Transaction transaction){
        return true;
    }
    /**
     * insert user method of the {@link DummyDataBaseController} class
     */
    public static boolean insert(User user){
        return true;
    }
    /**
     * update user method of the {@link DummyDataBaseController} class
     */
    public static boolean update(Transaction transaction){
        return true;
    }
    /**
     * delete user method of the {@link DummyDataBaseController} class
     */
    public static boolean delete(User user){
        return true;
    }
    /**
     * delete transaction method of the {@link DummyDataBaseController} class
     */
    public static boolean delete(Transaction transaction){
        return true;
    }


}
