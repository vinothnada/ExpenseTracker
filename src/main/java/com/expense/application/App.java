package com.expense.application;


import com.expense.application.Controller.BudgetController;
import com.expense.application.Controller.BudgetSetupController;
import com.expense.application.Controller.CategoryController;
import com.expense.application.Controller.TransactionController;
import com.expense.application.models.*;
import com.expense.application.models.enums.BudgetType;
import com.expense.application.models.enums.TransactionType;
import com.google.gson.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        // Using gson to print Json array of objetcs
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //create and list all categories
        Category cat1 = new Category("Misc","Other expenses");
        CategoryController categoryController  = new CategoryController();
        categoryController.createItem(cat1);
        List<Category> categories = new ArrayList<>();
        categories = categoryController.getAllItems();

        System.out.println(gson.toJson(categories));
        System.out.println("=========================================");

        //settingup budget
        BudgetSetup budgetSetup = new BudgetSetup("My Budget", BudgetType.MONTH);
        BudgetSetupController bcs = new BudgetSetupController();
        bcs.createItem(budgetSetup);
        List<BudgetSetup> budgetSetups = bcs.getAllItems();

        System.out.println(gson.toJson(budgetSetups));
        System.out.println("=========================================");

        //configure budget
        BudgetController budgetController = new BudgetController();
        BudgetData bdata1= new BudgetData(budgetSetups.get(0),categories.get(0),500);
        budgetController.createItem(bdata1);
        BudgetData bdata2 = new BudgetData(budgetSetups.get(0),categories.get(1),1000);
        budgetController.createItem(bdata2);
        BudgetData bdata3 = new BudgetData(budgetSetups.get(0),categories.get(2),1500);
        budgetController.createItem(bdata3);
        BudgetData bdata4 = new BudgetData(budgetSetups.get(0),categories.get(3),3000);
        budgetController.createItem(bdata4);
        BudgetData bdata5 = new BudgetData(budgetSetups.get(0),categories.get(4),5000);
        budgetController.createItem(bdata5);
        List<BudgetData> budgetList = budgetController.getAllItems();

        System.out.println(gson.toJson(budgetList));
        System.out.println("=========================================");

        //Add transactions
        TransactionController trans = new TransactionController();
        Transaction t1 = new Transaction(categories.get(0),50000, TransactionType.INCOME, parseDate("2023-01-01"));
        trans.createItem(t1);
        Transaction t2 = new Transaction(categories.get(1),10000,TransactionType.EXPENSE, parseDate("2023-01-05"));
        trans.createItem(t2);
        Transaction t3 = new Transaction(categories.get(2),12500,TransactionType.EXPENSE, parseDate("2023-01-15"));
        trans.createItem(t3);
        Transaction t4 = new Transaction(categories.get(3),13500,TransactionType.EXPENSE, parseDate("2023-01-17"));
        trans.createItem(t4);

        List<Transaction> AllTransactions = trans.getAllItems();

        System.out.println(gson.toJson(AllTransactions));
        System.out.println("=========================================");
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
