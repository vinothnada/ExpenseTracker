package com.expense.application;

import com.expense.application.Consumer.BudgetConsumer;
import com.expense.application.Consumer.BudgetSetupConsumer;
import com.expense.application.Consumer.CategoryConsumer;
import com.expense.application.Consumer.TransactionConsumer;
import com.expense.application.Injector.BudgetServiceInjector;
import com.expense.application.Injector.BudgetSetupServiceInjector;
import com.expense.application.Injector.CategoryServiceInjector;
import com.expense.application.Injector.TransactionServiceInjector;
import com.expense.application.models.BudgetData;
import com.expense.application.models.BudgetSetup;
import com.expense.application.models.Category;
import com.expense.application.models.Transaction;
import com.expense.application.models.dtos.TrackUsage;
import com.expense.application.models.enums.BudgetType;
import com.expense.application.models.enums.TransactionType;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.expense.application.App.parseDate;

public class App2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();

        CategoryServiceInjector catgoryInjector = new CategoryServiceInjector();
        CategoryConsumer categoryConsumer = catgoryInjector.getConsumer();

        BudgetSetupServiceInjector budgetSetupServiceInjector  = new BudgetSetupServiceInjector();
        BudgetSetupConsumer budgetSetupConsumer = budgetSetupServiceInjector.getConsumer();

        BudgetServiceInjector budgetServiceInjector  = new BudgetServiceInjector();
        BudgetConsumer budgetConsumer = budgetServiceInjector.getConsumer();

        TransactionServiceInjector transactionServiceInjector  = new TransactionServiceInjector();
        TransactionConsumer transactionConsumer = transactionServiceInjector.getConsumer();

        //create and list all categories
        Category cat1 = new Category("Misc","Other expenses");
        categoryConsumer.createItem(cat1);
        List<Category> categories = new ArrayList<>();
        categories = categoryConsumer.getAllItems();

//        System.out.println(gson.toJson(categories));
//        System.out.println("=========================================");

        //settingup budget
        BudgetSetup budgetSetup = new BudgetSetup("My Budget", BudgetType.MONTH);
        budgetSetupConsumer.createItem(budgetSetup);
        List<BudgetSetup> budgetSetups = budgetSetupConsumer.getAllItems();

//        System.out.println(gson.toJson(budgetSetups));
//        System.out.println("=========================================");

        //configure budget
        BudgetData bdata1= new BudgetData(budgetSetups.get(0),categories.get(0),0);
        budgetConsumer.createItem(bdata1);
        BudgetData bdata2 = new BudgetData(budgetSetups.get(0),categories.get(1),10000);
        budgetConsumer.createItem(bdata2);
        BudgetData bdata3 = new BudgetData(budgetSetups.get(0),categories.get(2),20000);
        budgetConsumer.createItem(bdata3);
        BudgetData bdata4 = new BudgetData(budgetSetups.get(0),categories.get(3),30000);
        budgetConsumer.createItem(bdata4);
        BudgetData bdata5 = new BudgetData(budgetSetups.get(0),categories.get(4),50000);
        budgetConsumer.createItem(bdata5);
        List<BudgetData> budgetList = budgetConsumer.getAllItems();

//        System.out.println(gson.toJson(budgetList));
//        System.out.println("=========================================");

        //Add transactions
        Transaction t1 = new Transaction(categories.get(0),100000, TransactionType.INCOME, parseDate("2023-01-01"));
        transactionConsumer.createItem(t1);
        Transaction t2 = new Transaction(categories.get(1),5000,TransactionType.EXPENSE, parseDate("2023-01-05"));
        transactionConsumer.createItem(t2);
        Transaction t3 = new Transaction(categories.get(2),15000,TransactionType.EXPENSE, parseDate("2023-01-15"));
        transactionConsumer.createItem(t3);
        Transaction t4 = new Transaction(categories.get(3),22500,TransactionType.EXPENSE, parseDate("2023-01-17"));
        transactionConsumer.createItem(t4);

        List<Transaction> AllTransactions = transactionConsumer.getAllItems();

//        System.out.println(gson.toJson(AllTransactions));
//        System.out.println("=========================================");

        // Budget calculations
        List<TrackUsage> usageList = new ArrayList<>();

        categories.forEach(cat -> {
            TrackUsage tru = new TrackUsage();
            tru.setCategory(cat.getName());
            budgetList.forEach(i -> {
                if(cat.getId() == i.getCategory().getId()){
                    tru.setBudget(i.getAmount());
                }
            });
            AllTransactions.forEach(trans -> {
                if(cat.getId() == trans.getCategory().getId()){
                    if(trans.getTransactionType() == TransactionType.INCOME){
                        tru.setIncome(trans.getAmount());
                        tru.setExpense(0);
                    }else{
                        tru.setExpense(trans.getAmount());
                        tru.setIncome(0);
                    }
                }
            });
            usageList.add(tru);
        });

        usageList.forEach(item -> {
            double budgetPercentage = 0;
            if(item.getExpense() > 0){
                budgetPercentage = item.getExpense() * 100 / item.getBudget();
            }

            item.setBudgetPercentage(budgetPercentage);
        });

        System.out.println(gson.toJson(usageList));
        System.out.println("=========================================");

    }
}
