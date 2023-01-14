package com.expense.application.Controller;

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
public class DummyDataBaseController {
    /**
     * DummyDataBaseController private static instance for a singleton connection
     */
    private static DummyDataBaseController dbInstance;
    private static LinkedList<User> userList = new LinkedList<>();
    private static HashMap<User, Transaction> transactionList = new HashMap<>();
    private static LinkedList<Category> categoryList = new LinkedList();
    private static HashMap<User, Category> userDefinedCategoryList = new HashMap<>();
    private static LinkedList<BudgetType> budgetTypeList = new LinkedList<>();

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
//            ConfigReader reader = new ConfigReader("settings.properties");
//            String appName = reader.getProperty("application.name");
            dbInstance = new  DummyDataBaseController();
        }
        return dbInstance;
    }
    /**
     * insert Transaction method of the {@link DummyDataBaseController} class
     */
    public static boolean insert(User user, Transaction transaction) throws CustomExceptionController {
        try {
            if(user != null && transaction != null){
                transactionList.put(user, transaction);
                return true;
            }
            return false;
        }catch (Exception er){
            throw new CustomExceptionController("Failed to insert new transaction " + er.getMessage());
        }
    }
    /**
     * insert User method of the {@link DummyDataBaseController} class
     */
    public static boolean insert(User user) throws CustomExceptionController {
        try {
            if(user != null){
                userList.add(user);
                return true;
            }
            return false;
        }catch (Exception er){
            throw new CustomExceptionController("Failed to insert new user " + er.getMessage());
        }
    }
    /**
     * insert category method of the {@link DummyDataBaseController} class
     */
    public static boolean insert(Category category) throws CustomExceptionController {
        try {
            if(category != null){
                categoryList.add(category);
                return true;
            }
            return false;
        }catch (Exception er){
            throw new CustomExceptionController("Failed to insert new category " + er.getMessage());
        }
    }
    /**
     * insert User defined category method of the {@link DummyDataBaseController} class
     */
    public static boolean insert(User user, Category category) throws CustomExceptionController {
        try {
            if(user != null){
                userDefinedCategoryList.put(user, category);
                return true;
            }
            return false;
        }catch (Exception er){
            throw new CustomExceptionController("Failed to insert new user defined category " + er.getMessage());
        }
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
