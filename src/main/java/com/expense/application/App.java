package com.expense.application;

import com.expense.application.Consumer.BudgetConsumer;
import com.expense.application.Consumer.BudgetSetupConsumer;
import com.expense.application.Consumer.CategoryConsumer;
import com.expense.application.Consumer.TransactionConsumer;
import com.expense.application.Injector.BudgetServiceInjector;
import com.expense.application.Injector.BudgetSetupServiceInjector;
import com.expense.application.Injector.CategoryServiceInjector;
import com.expense.application.Injector.TransactionServiceInjector;
import com.expense.application.models.*;
import com.expense.application.models.enums.BudgetType;
import com.expense.application.models.enums.TransactionType;
import com.google.gson.*;
import com.expense.application.models.Category;
import com.expense.application.models.dtos.TrackUsage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Gson gson = new Gson();

    private static final CategoryServiceInjector catgoryInjector = new CategoryServiceInjector();
    private static final CategoryConsumer categoryConsumer = catgoryInjector.getConsumer();

    private static final BudgetSetupServiceInjector budgetSetupServiceInjector = new BudgetSetupServiceInjector();
    private static final BudgetSetupConsumer budgetSetupConsumer = budgetSetupServiceInjector.getConsumer();

    private static final BudgetServiceInjector budgetServiceInjector = new BudgetServiceInjector();
    private static final BudgetConsumer budgetConsumer = budgetServiceInjector.getConsumer();

    private static final TransactionServiceInjector transactionServiceInjector = new TransactionServiceInjector();
    private static final TransactionConsumer transactionConsumer = transactionServiceInjector.getConsumer();

    /**
     * Method that prints main menu items and accepts a choice then display
     * appropriate sub menu
     */
    private static void showMainMenu() {
        loop: while (true) {
            System.out.println("Enter number to choose option");
            System.out.println("===============================================");
            System.out.println("1. Add a new transaction ");
            System.out.println("2. View recent transactions");
            System.out.println("3. Manage Transactions");
            System.out.println("4. Manage Categories");
            System.out.println("5. Manage Budgets");
            System.out.println("6. Track Budget & Progress");
            System.out.println("-1. Exit application");
            System.out.println("===============================================");

            System.out.print("Enter option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showAddTransactionMenu();
                    break loop;
                case 2:
                    printRecentTransactions();
                    break loop;
                case 3:
                    showManageTransactionsMenu();
                    break loop;
                case 4:
                    showManageCategoriesMenu();
                    break loop;
                case 5:
                    showManageBudgetsMenu();
                    break loop;

                case 6:
                    showBudgetProgress();
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

            if (!categoryConsumer.isValidItem(categoryId)) {
                System.out.println("Invalid category id");
                continue;
            }

            Category category = categoryConsumer.getItem(categoryId);

            System.out.print("Enter amount for the transaction: ");
            double amount = scanner.nextDouble();

            Transaction transaction = new Transaction(category, amount, transactionType, new Date());
            transactionConsumer.createItem(transaction);

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
        List<Category> categories = categoryConsumer.getAllItems();

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
        List<Transaction> transactions = transactionConsumer.getRecentItems();

        if (transactions.isEmpty()) {
            System.out.println("No recent transactions found.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction.toString());
            }
        }
        showMainMenu();
    }

    /**
     * Method that prints all transactions
     */
    private static void printAllTransactions() {
        System.out.println("All transactions: ");
        List<Transaction> transactions = transactionConsumer.getAllItems();

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction.toString());
            }
        }
        showMainMenu();
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
            System.out.println("3. - View all transactions");
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
                case 3:
                    printAllTransactions();
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

            if (!transactionConsumer.isValidItem(transactionId)) {
                System.out.println("Invalid transaction id");
                continue;
            }

            printAllCategories();

            System.out.println("Enter a new category ID: ");
            int categoryId = scanner.nextInt();

            if (!categoryConsumer.isValidItem(categoryId)) {
                System.out.println("Invalid category id");
                continue;
            }

            System.out.println("Enter a new amount: ");
            double amount = scanner.nextDouble();

            Transaction transaction = transactionConsumer.getItem(transactionId);
            Category category = categoryConsumer.getItem(categoryId);

            transaction.setCategory(category);
            transaction.setAmount(amount);
            transactionConsumer.editItem(transaction.getId(), transaction);

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

            if (!transactionConsumer.isValidItem(transactionId)) {
                System.out.println("Invalid transaction id");
                continue;
            }

            transactionConsumer.deleteItem(transactionId);

            System.out.println("Transaction deleted successfully");
            break;
        }

        showManageTransactionsMenu();
    }

    /**
     * Method that prints options for managing categories and accepts a choice
     */
    private static void showManageCategoriesMenu() {
        loop: while (true) {
            System.out.println("Enter number to choose option");
            System.out.println("===============================================");
            System.out.println("1. - Create a category");
            System.out.println("2. - Delete a category");
            System.out.println("3. - View categories");
            System.out.println("0. - To view main menu");
            System.out.println("-1 - To exit application");
            System.out.println("===============================================");

            System.out.print("Enter option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createCategory();
                    break loop;
                case 2:
                    deleteCategory();
                    break loop;
                case 3:
                    printAllCategories();
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
     * Method that handles the logic of creating a category
     */
    private static void createCategory() {
        System.out.println("Enter category name: ");
        String name = scanner.next();

        System.out.println("Enter category description: ");
        String description = scanner.next();

        Category category = new Category(name, description);
        categoryConsumer.createItem(category);

        System.out.println("Category created successfully");
        showManageCategoriesMenu();
    }

    /**
     * Method that handles the logic of deleting a category
     */
    private static void deleteCategory() {
        printAllCategories();

        while (true) {
            System.out.println("Enter category ID to delete: ");
            int categoryId = scanner.nextInt();

            if (!categoryConsumer.isValidItem(categoryId)) {
                System.out.println("Invalid category id");
                continue;
            }

            categoryConsumer.deleteItem(categoryId);

            System.out.println("Category deleted successfully");
            break;
        }

        showManageCategoriesMenu();
    }

    /**
     * Method that prints options for managing budgets and accepts a choice
     */
    private static void showManageBudgetsMenu() {
        loop: while (true) {
            System.out.println("Enter number to choose option");
            System.out.println("===============================================");
            System.out.println("1. - Create a budget");
            System.out.println("2. - Delete a budget");
            System.out.println("3. - View budgets");
            System.out.println("0. - To view main menu");
            System.out.println("-1 - To exit application");
            System.out.println("===============================================");

            System.out.print("Enter option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createBudget();
                    break loop;
                case 2:
                    deleteBudget();
                    break loop;
                case 3:
                    printAllBudgets();
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
     * Method that handles the logic of creating a budget
     */
    private static void createBudget() {
        System.out.println("Create New Budget");

        while (true) {
            printAllBudgetTypes();

            System.out.println("Enter budget name: ");
            String name = scanner.next();

            System.out.println("Enter budget type: ");
            int budgetTypeIndex = scanner.nextInt();

            if (budgetTypeIndex < 1 || budgetTypeIndex > BudgetType.values().length) {
                System.out.println("Invalid budget type");
                continue;
            }

            BudgetType budgetType = BudgetType.values()[budgetTypeIndex - 1];

            printAllCategories();

            System.out.println("Enter category ID: ");
            int categoryId = scanner.nextInt();

            if (!categoryConsumer.isValidItem(categoryId)) {
                System.out.println("Invalid category id");
                continue;
            }

            Category category = categoryConsumer.getItem(categoryId);

            System.out.println("Enter budget amount: ");
            double amount = scanner.nextDouble();

            BudgetSetup budgetSetup = new BudgetSetup(name, budgetType);
            budgetSetupConsumer.createItem(budgetSetup);

            BudgetData budgetData = new BudgetData(budgetSetup, category, amount);
            budgetConsumer.createItem(budgetData);

            System.out.println("Budget created successfully");
            break;
        }

        showManageBudgetsMenu();
    }

    /**
     * Method that handles the logic of deleting a budget
     */
    private static void deleteBudget() {
        printAllBudgets();

        while (true) {
            System.out.println("Enter budget ID to delete: ");
            int budgetId = scanner.nextInt();

            if (!budgetConsumer.isValidItem(budgetId)) {
                System.out.println("Invalid budget id");
                continue;
            }

            BudgetData budget = budgetConsumer.getItem(budgetId);
            budgetConsumer.deleteItem(budgetId);
            budgetSetupConsumer.deleteItem(budget.getBudgetSetup().getId());

            System.out.println("Budget deleted successfully");
            break;
        }

        showManageBudgetsMenu();
    }

    // print budget type enum with index
    private static void printAllBudgetTypes() {
        System.out.println("Available budget types, ");
        int index = 1;
        for (BudgetType budgetType : BudgetType.values()) {
            System.out.println(index + ". " + budgetType);
            index++;
        }
    }

    // print all budgets in budgetConsumer
    private static void printAllBudgets() {
        List<BudgetData> budgets = budgetConsumer.getAllItems();
        if(budgets.size() == 0){
            System.out.println("No Budgets Recorded");
        }else{
            System.out.println("All Budgets");
            for (BudgetData budget : budgets) {
                System.out.println(budget.toString());
            }
        }
        showMainMenu();
    }

    // print all categories in categoryConsumer
    public static void showBudgetProgress() {
        System.out.println("Budget Progress,\n");

        List<Transaction> allTransactions = transactionConsumer.getAllItems();
        List<Category> categories = categoryConsumer.getAllItems();
        List<BudgetData> budgetList = budgetConsumer.getAllItems();

        // Budget calculations
        List<TrackUsage> usageList = new ArrayList<>();

        categories.forEach(cat -> {
            TrackUsage tru = new TrackUsage();
            tru.setCategory(cat.getName());
            budgetList.forEach(i -> {
                if (cat.getId() == i.getCategory().getId()) {
                    tru.setBudget(i.getAmount());
                }
            });
            allTransactions.forEach(trans -> {
                if (cat.getId() == trans.getCategory().getId()) {
                    if (trans.getTransactionType() == TransactionType.INCOME) {
                        tru.setIncome(trans.getAmount());
                        tru.setExpense(0);
                    } else {
                        tru.setExpense(trans.getAmount());
                        tru.setIncome(0);
                    }
                }
            });
            usageList.add(tru);
        });

        usageList.forEach(item -> {
            double budgetPercentage = 0;
            if (item.getExpense() > 0) {
                budgetPercentage = item.getExpense() * 100 / item.getBudget();
            }

            item.setBudgetPercentage(budgetPercentage);
        });

        usageList.forEach(item -> {
            System.out.println("Category: " + item.getCategory() + " | " + "Budget: " + item.getBudget() + " | "
                    + "Income: " + item.getIncome() + " | " + "Expense: " + item.getExpense());
            int progress = (int) item.getBudgetPercentage();
            System.out.println("Progress,");
            showProgress(progress);
            System.out.println("\n");
        });

        System.out.println("\n");
        showMainMenu();
    }

    public static void main(String[] args) {
        // start the main menu
        showMainMenu();
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static void showProgress(int percent) {
        StringBuilder progressBar = new StringBuilder("[");
        for (int i = 0; i < 50; i++) {
            if (i < (percent / 2)) {
                progressBar.append("=");
            } else {
                progressBar.append(" ");
            }
        }
        progressBar.append("] ").append(percent).append("%");
        System.out.print("\r" + progressBar);
    }

}
