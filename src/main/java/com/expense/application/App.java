package com.expense.application;

import com.expense.application.Controller.BudgetController;
import com.expense.application.Controller.BudgetSetupController;
import com.expense.application.Controller.CategoryController;
import com.expense.application.Controller.TransactionController;
import com.expense.application.models.*;
import com.expense.application.models.enums.BudgetType;
import com.expense.application.models.enums.TransactionType;
import com.google.gson.*;
import com.expense.application.models.Category;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Gson gson = new Gson();
    private static TransactionController transactionController = new TransactionController();
    private static CategoryController categoryController = new CategoryController();
    private static BudgetController budgetController = new BudgetController();
    private static BudgetSetupController budgetSetupController = new BudgetSetupController();

    /**
     * Method that prints main menu items and accepts a choice then display
     * appropriate sub menu
     */
    private static void showMainMenu() {
        while (true) {
            System.out.println("Enter number to choose option");
            System.out.println("===============================================");
            System.out.println("1. Add a new transaction ");
            System.out.println("2. View recent transactions");
            System.out.println("3. Manage Transactions");
            System.out.println("4. Manage Categories");
            System.out.println("5. Track Budget & Progress");
            System.out.println("-1. Exit application");
            System.out.println("===============================================");

            System.out.print("Enter option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showAddTransactionMenu();
                    break;
                case 2:
                    printRecentTransactions();
                    break;
                case 3:
                    showManageTransactionsMenu();
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
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    /**
     * Method that prints options for adding an income or expense transaction and
     * accepts a choice
     */
    private static void showAddTransactionMenu() {
        loop: while (true) {
            System.out.println("Enter number to choose option");
            System.out.println("===============================================");
            System.out.println("1. - To add a new income transaction ");
            System.out.println("2. - To add a new expense transaction");
            System.out.println("0. - To view main menu");
            System.out.println("-1. Exit application");
            System.out.println("===============================================");

            System.out.print("Enter option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addTransaction(TransactionType.INCOME);
                    break loop;
                case 2:
                    addTransaction(TransactionType.EXPENSE);
                    break loop;
                case 0:
                    showMainMenu();
                    break loop;
                case -1:
                    System.out.println("Exiting application");
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    /**
     * Method that handles the logic of adding a new income or expense transaction
     * 
     * @param transactionType - The type of transaction to add (Expense or Income)
     */

    private static void addTransaction(TransactionType transactionType) {
        while (true) {
            System.out.println(transactionType == TransactionType.INCOME ? "Add new income transaction"
                    : "Add new expense transaction");
            System.out.println("===============================================");

            printAllCategories();

            System.out.print("Enter category id for your transaction: ");

            int categoryId = scanner.nextInt();

            if (categoryController.isValidItem(categoryId) == false) {
                System.out.println("Invalid category id");
                continue;
            }

            Category category = categoryController.getItem(categoryId);

            System.out.print("Enter amount for the transaction: ");
            double amount = scanner.nextDouble();

            Transaction transaction = new Transaction(category, amount, transactionType, new Date());
            transactionController.createItem(transaction);

            System.out.println("Transaction added successfully.\n");
            break;
        }

        showAddTransactionMenu();
    }

    /**
     * Method that prints all categories in the database
     */
    private static void printAllCategories() {
        System.out.println("All categories:");
        List<Category> categories = categoryController.getAllItems();

        if (categories.isEmpty()) {
            System.out.println("No categories found.");
        } else {
            for (Category category : categories) {
                System.out.println(category.toString());
            }
        }
    }

    /**
     * Method that prints all recent transactions
     */
    private static void printRecentTransactions() {
        System.out.println("Recent transactions:");
        List<Transaction> transactions = transactionController.getRecentItems();

        if (transactions.isEmpty()) {
            System.out.println("No recent transactions found.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction.toString());
            }
        }
    }

    /**
     * Method that prints all transactions
     */
    private static void printAllTransactions() {
        System.out.println("All transactions: ");
        List<Transaction> transactions = transactionController.getAllItems();

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction.toString());
            }
        }
    }

    /**
     * Method that prints options for managing transactions and accepts a choice
     */
    private static void showManageTransactionsMenu() {
        loop: while (true) {
            System.out.println("Enter number to choose option");
            System.out.println("===============================================");
            System.out.println("1. - Edit a transaction");
            System.out.println("2. - Delete a transaction");
            System.out.println("0. - To view main menu");
            System.out.println("-1 - To exit application");
            System.out.println("===============================================");

            System.out.print("Enter option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    editTransaction();
                    break loop;
                case 2:
                    deleteTransaction();
                    break loop;
                case 0:
                    showMainMenu();
                    break loop;
                case -1:
                    System.out.println("Exiting application");
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    /**
     * Method that handles the logic of editing a transaction
     */
    private static void editTransaction() {
        printAllTransactions();

        while (true) {
            System.out.println("Enter transaction ID to edit: ");
            int transactionId = scanner.nextInt();

            if (transactionController.isValidItem(transactionId) == false) {
                System.out.println("Invalid transaction id");
                continue;
            }

            printAllCategories();

            System.out.println("Enter a new category ID: ");
            int categoryId = scanner.nextInt();

            if (categoryController.isValidItem(categoryId) == false) {
                System.out.println("Invalid category id");
                continue;
            }

            System.out.println("Enter a new amount: ");
            double amount = scanner.nextDouble();

            Transaction transaction = transactionController.getItem(transactionId);
            Category category = categoryController.getItem(categoryId);

            transaction.setCategory(category);
            transaction.setAmount(amount);
            transactionController.editItem(transaction.getId(), transaction);

            System.out.println("Transaction updated successfully");
            break;
        }

        showManageTransactionsMenu();
    }

    /**
     * Method that handles the logic of deleting a transaction
     */
    private static void deleteTransaction() {
        printAllTransactions();

        while (true) {
            System.out.println("Enter transaction ID to delete: ");
            int transactionId = scanner.nextInt();

            if (transactionController.isValidItem(transactionId) == false) {
                System.out.println("Invalid transaction id");
                continue;
            }

            transactionController.deleteItem(transactionId);

            System.out.println("Transaction deleted successfully");
            break;
        }

        showManageTransactionsMenu();
    }

    public static void main(String[] args) {
        // create and list all categories
        Category cat1 = new Category("Misc", "Other expenses");
        categoryController.createItem(cat1);
        List<Category> categories = new ArrayList<>();
        categories = categoryController.getAllItems();

        System.out.println(gson.toJson(categories));
        System.out.println("=========================================");

        // settingup budget
        BudgetSetup budgetSetup = new BudgetSetup("My Budget", BudgetType.MONTH);
        budgetSetupController.createItem(budgetSetup);
        List<BudgetSetup> budgetSetups = budgetSetupController.getAllItems();

        System.out.println(gson.toJson(budgetSetups));
        System.out.println("=========================================");

        // configure budget
        BudgetData bdata1 = new BudgetData(budgetSetups.get(0), categories.get(0),
                500);
        budgetController.createItem(bdata1);
        BudgetData bdata2 = new BudgetData(budgetSetups.get(0), categories.get(1),
                1000);
        budgetController.createItem(bdata2);
        BudgetData bdata3 = new BudgetData(budgetSetups.get(0), categories.get(2),
                1500);
        budgetController.createItem(bdata3);
        BudgetData bdata4 = new BudgetData(budgetSetups.get(0), categories.get(3),
                3000);
        budgetController.createItem(bdata4);
        BudgetData bdata5 = new BudgetData(budgetSetups.get(0), categories.get(4),
                5000);
        budgetController.createItem(bdata5);
        List<BudgetData> budgetList = budgetController.getAllItems();

        System.out.println(gson.toJson(budgetList));
        System.out.println("=========================================");

        // Add transactions
        Transaction t1 = new Transaction(categories.get(0), 50000,
                TransactionType.INCOME, parseDate("2023-01-01"));
        transactionController.createItem(t1);
        Transaction t2 = new Transaction(categories.get(1), 10000,
                TransactionType.EXPENSE, parseDate("2023-01-05"));
        transactionController.createItem(t2);
        Transaction t3 = new Transaction(categories.get(2), 12500,
                TransactionType.EXPENSE, parseDate("2023-01-15"));
        transactionController.createItem(t3);
        Transaction t4 = new Transaction(categories.get(3), 13500,
                TransactionType.EXPENSE, parseDate("2023-01-17"));
        transactionController.createItem(t4);

        List<Transaction> AllTransactions = transactionController.getAllItems();

        System.out.println(gson.toJson(AllTransactions));
        System.out.println("=========================================");

        showMainMenu();
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

}
