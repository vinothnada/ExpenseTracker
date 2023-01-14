package com.expense.application.Controller;

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

    public static boolean insert(Object obj){
        return true;
    }

    public static boolean update(Object obj){
        return true;
    }

    public static boolean delete(Object obj){
        return true;
    }


}
