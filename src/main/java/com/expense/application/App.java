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

public class App {
    private static void showMainMenu() {
        System.out.println("Enter number to choose option");
        System.out.println("===============================================");
        System.out.println("Enter '1'  - To add a new transaction ");
        System.out.println("Enter '2'  - To View recent transactions");
        System.out.println("Enter '3'  - Manage Transactions");
        System.out.println("Enter '4'  - Manage Categories");
        System.out.println("Enter '5'  - Track Budget & Progress");
        System.out.println("Enter '-1' - To exit application");
        System.out.println("===============================================");

        while (true) {
            System.out.print("Enter option: ");
            int choice = Integer.parseInt(System.console().readLine());
            switch (choice) {
                case 1:
                    System.out.println("Add new transaction");
                    break;
                case 2:
                    System.out.println("View recent transactions");
                    break;
                case 3:
                    System.out.println("Manage Transactions");
                    break;
                case 4:
                    System.out.println("Manage Categories");
                    break;
                case 5:
                    System.out.println("Track Budget & Progress");
                    break;
                case -1:
                    System.out.println("Exiting application");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private static void showAddTransactionMenu() {
        while (true) {
            System.out.println("Enter number to choose option");
            System.out.println("===============================================");
            System.out.println("Enter '1'  - To add a new income transaction ");
            System.out.println("Enter '2'  - To add a new expense transaction");
            System.out.println("Enter '0' - To view main menu");
            System.out.println("===============================================");

            System.out.print("Enter option: ");
            int choice = Integer.parseInt(System.console().readLine());
            switch (choice) {
                case 1:
                    addTransaction(TransactionType.INCOME);
                    break;
                case 2:
                    addTransaction(TransactionType.EXPENSE);
                    break;
                case 0:
                    showMainMenu();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private static void addTransaction(TransactionType transactionType) {
        while (true) {
            System.out.println(transactionType == TransactionType.INCOME ? "Add new income transaction"
                    : "Add new expense transaction");
            System.out.println("===============================================");

            System.out.println("Choose the category for the transaction");
            printAllCategories();

            System.out.print("Enter category id if your transaction: ");

            int categoryId = Integer.parseInt(System.console().readLine());
            CategoryController categoryController = new CategoryController();

            if (categoryController.isValidItem(categoryId) == false) {
                System.out.println("Invalid category id");
                continue;
            }

            Category category = categoryController.getItem(categoryId);

            System.out.print("Enter amount for the transaction: ");
            double amount = Double.parseDouble(System.console().readLine());

            TransactionController transactionController = new TransactionController();
            Transaction transaction = new Transaction(category, amount, transactionType, new Date());
            transactionController.createItem(transaction);

            System.out.println("Transaction added successfully");
            break;
        }

        showAddTransactionMenu();
    }

    private static void printAllCategories() {
        CategoryController categoryController = new CategoryController();
        List<Category> categories = categoryController.getAllItems();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(categories));
    }

    public static void main(String[] args) {
        // Using gson to print Json array of objetcs
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // create and list all categories
        Category cat1 = new Category("Misc", "Other expenses");
        CategoryController categoryController = new CategoryController();
        categoryController.createItem(cat1);
        List<Category> categories = new ArrayList<>();
        categories = categoryController.getAllItems();

        System.out.println(gson.toJson(categories));
        System.out.println("=========================================");

        // settingup budget
        BudgetSetup budgetSetup = new BudgetSetup("My Budget", BudgetType.MONTH);
        BudgetSetupController bcs = new BudgetSetupController();
        bcs.createItem(budgetSetup);
        List<BudgetSetup> budgetSetups = bcs.getAllItems();

        System.out.println(gson.toJson(budgetSetups));
        System.out.println("=========================================");

        // configure budget
        BudgetController budgetController = new BudgetController();
        BudgetData bdata1 = new BudgetData(budgetSetups.get(0), categories.get(0), 500);
        budgetController.createItem(bdata1);
        BudgetData bdata2 = new BudgetData(budgetSetups.get(0), categories.get(1), 1000);
        budgetController.createItem(bdata2);
        BudgetData bdata3 = new BudgetData(budgetSetups.get(0), categories.get(2), 1500);
        budgetController.createItem(bdata3);
        BudgetData bdata4 = new BudgetData(budgetSetups.get(0), categories.get(3), 3000);
        budgetController.createItem(bdata4);
        BudgetData bdata5 = new BudgetData(budgetSetups.get(0), categories.get(4), 5000);
        budgetController.createItem(bdata5);
        List<BudgetData> budgetList = budgetController.getAllItems();

        System.out.println(gson.toJson(budgetList));
        System.out.println("=========================================");

        // Add transactions
        TransactionController trans = new TransactionController();
        Transaction t1 = new Transaction(categories.get(0), 50000, TransactionType.INCOME, parseDate("2023-01-01"));
        trans.createItem(t1);
        Transaction t2 = new Transaction(categories.get(1), 10000, TransactionType.EXPENSE, parseDate("2023-01-05"));
        trans.createItem(t2);
        Transaction t3 = new Transaction(categories.get(2), 12500, TransactionType.EXPENSE, parseDate("2023-01-15"));
        trans.createItem(t3);
        Transaction t4 = new Transaction(categories.get(3), 13500, TransactionType.EXPENSE, parseDate("2023-01-17"));
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
