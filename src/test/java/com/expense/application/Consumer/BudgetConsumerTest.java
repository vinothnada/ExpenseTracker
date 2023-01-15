package com.expense.application.Consumer;

import com.expense.application.Injector.BudgetServiceInjector;
import com.expense.application.models.BudgetData;
import com.expense.application.services.budget.BudgetServiceImpl;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class BudgetConsumerTest extends TestCase {

    private BudgetServiceInjector injector;
    @Before
    public void setUp(){
        //mock the injector with anonymous class
        injector = new BudgetServiceInjector() {

            @Override
            public BudgetConsumer getConsumer() {
                //mock the message service
                return new BudgetConsumer(new BudgetServiceImpl() {

                    List<BudgetData> budgetDataList = new ArrayList<>();

                    @Override
                    public String createItem(BudgetData budgetData) {
                        budgetDataList.add(budgetData);
                        return "BudgetData Created Successfully";
                    }

                    @Override
                    public String editItem(int id , BudgetData budgetData) {
                        return "BudgetData updated Successfully";
                    }

                    @Override
                    public BudgetData getItem(int id) {
                        return new BudgetData();
                    }
                });
            }
        };
    }


    public void testCreateItem() {
        BudgetData budgetData = new BudgetData(1,null,null,1000);
        BudgetConsumer consumer =injector.getConsumer();
        consumer.createItem(budgetData);
    }

    public void testGetAllItems() {
        BudgetConsumer consumer =injector.getConsumer();
        consumer.getAllItems();
    }

    public void testEditItem() {
        BudgetData budgetData = new BudgetData(null,null,1000);
        BudgetConsumer consumer =injector.getConsumer();
        consumer.editItem(1,budgetData);
    }

    public void testGetItem() {
        BudgetConsumer consumer =injector.getConsumer();
        consumer.getItem(1);
    }

    public void testIsValidItem() {
        BudgetConsumer consumer =injector.getConsumer();
        consumer.isValidItem(1);
    }

    public void testDeleteItem() {
        BudgetConsumer consumer =injector.getConsumer();
        consumer.deleteItem(1);
    }

    @After
    public void tear(){
        injector = null;
    }
}