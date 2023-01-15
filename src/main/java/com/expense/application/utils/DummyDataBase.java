package com.expense.application.utils;

import com.expense.application.models.Category;
import com.expense.application.models.Transaction;
import com.expense.application.models.User;
import com.expense.application.models.enums.BudgetType;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Dummy DataBase Controller represents an in memory database created with data structures and algorithms
 */
public class DummyDataBase {
    /**
     * DummyDataBaseController private static instance for a singleton connection
     */
    private static DummyDataBase dbInstance;
    private static LinkedList<User> userList = new LinkedList<>();
    private static HashMap<User, Transaction> transactionList = new HashMap<>();
    private static LinkedList<Category> categoryList = new LinkedList();
    private static HashMap<User, Category> userDefinedCategoryList = new HashMap<>();
    private static LinkedList<BudgetType> budgetTypeList = new LinkedList<>();

    /**
     * DummyDataBaseController constructor of the {@link DummyDataBase} class
     */
    private DummyDataBase(){
    }
    /**
     * getInstance method of the {@link DummyDataBase} class
     */
    public static DummyDataBase getInstance() throws IOException {
        if (dbInstance == null)
        {
//            ConfigReader reader = new ConfigReader("settings.properties");
//            String appName = reader.getProperty("application.name");
            dbInstance = new DummyDataBase();
        }
        return dbInstance;
    }
    /**
     * insert Transaction method of the {@link DummyDataBase} class
     */
    public static boolean insert(User user, Transaction transaction) throws CustomExceptions {
        try {
            if(user != null && transaction != null){
                transactionList.put(user, transaction);
                return true;
            }
            return false;
        }catch (Exception er){
            throw new CustomExceptions("Failed to insert new transaction " + er.getMessage());
        }
    }
    /**
     * insert User method of the {@link DummyDataBase} class
     */
    public static boolean insert(User user) throws CustomExceptions {
        try {
            if(user != null){
                userList.add(user);
                return true;
            }
            return false;
        }catch (Exception er){
            throw new CustomExceptions("Failed to insert new user " + er.getMessage());
        }
    }
    /**
     * insert category method of the {@link DummyDataBase} class
     */
    public static boolean insert(Category category) throws CustomExceptions {
        try {
            if(category != null){
                categoryList.add(category);
                return true;
            }
            return false;
        }catch (Exception er){
            throw new CustomExceptions("Failed to insert new category " + er.getMessage());
        }
    }
    /**
     * insert User defined category method of the {@link DummyDataBase} class
     */
    public static boolean insert(User user, Category category) throws CustomExceptions {
        try {
            if(user != null && userList.contains(user)){
                userDefinedCategoryList.put(user, category);
                return true;
            }
            return false;
        }catch (Exception er){
            throw new CustomExceptions("Failed to insert new user defined category " + er.getMessage());
        }
    }



}
