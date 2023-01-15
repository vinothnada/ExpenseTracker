package com.expense.application.Consumer;

import com.expense.application.Injector.BudgetSetupServiceInjector;
import com.expense.application.models.BudgetSetup;
import com.expense.application.services.budgetSetup.BudgetSetupServiceImpl;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class BudgetSetupConsumerTest extends TestCase {

    private BudgetSetupServiceInjector injector;
    @Before
    public void setUp(){
        //mock the injector with anonymous class
        injector = new BudgetSetupServiceInjector() {

            @Override
            public BudgetSetupConsumer getConsumer() {
                //mock the message service
                return new BudgetSetupConsumer(new BudgetSetupServiceImpl() {

                    List<BudgetSetup> budgetSetupList = new ArrayList<>();

                    @Override
                    public String createItem(BudgetSetup budgetSetup) {
                        budgetSetupList.add(budgetSetup);
                        return "BudgetSetup Created Successfully";
                    }

                    @Override
                    public String editItem(int id , BudgetSetup budgetSetup) {
                        return "BudgetSetup updated Successfully";
                    }

                });
            }
        };
    }


    public void testCreateItem() {
        BudgetSetup budgetSetup = new BudgetSetup("shops",null);
        BudgetSetupConsumer consumer =injector.getConsumer();
        consumer.createItem(budgetSetup);
    }

    public void testGetAllItems() {
        BudgetSetupConsumer consumer =injector.getConsumer();
        consumer.getAllItems();
    }

    public void testEditItem() {
        BudgetSetup budgetSetup = new BudgetSetup("shops",null);
        BudgetSetupConsumer consumer =injector.getConsumer();
        consumer.editItem(1,budgetSetup);
    }

    public void testDeleteItem() {
        BudgetSetupConsumer consumer =injector.getConsumer();
        consumer.deleteItem(1);
    }

    @After
    public void tear(){
        injector = null;
    }
}