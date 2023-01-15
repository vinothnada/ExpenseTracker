package com.expense.application.Consumer;


import com.expense.application.Injector.TransactionServiceInjector;
import com.expense.application.models.Transaction;
import com.expense.application.services.transaction.TransactionServiceImpl;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static com.expense.application.App.parseDate;

public class TransactionConsumerTest extends TestCase {

    private TransactionServiceInjector injector;
    @Before
    public void setUp(){
        //mock the injector with anonymous class
        injector = new TransactionServiceInjector() {

            @Override
            public TransactionConsumer getConsumer() {
                //mock the message service
                return new TransactionConsumer(new TransactionServiceImpl() {

                    List<Transaction> tsList = new ArrayList<>();

                    @Override
                    public String createItem(Transaction ts) {
                        tsList.add(ts);
                        return "Transaction Created Successfully";
                    }

                    @Override
                    public String editItem(int id , Transaction ts) {
                        return "Transaction updated Successfully";
                    }

                    @Override
                    public Transaction getItem(int id) {
                        return new Transaction();
                    }
                });
            }
        };
    }


    public void testCreateItem() {
        Transaction ts = new Transaction(null,500,null,parseDate("2023-01-17"));
        TransactionConsumer consumer =injector.getConsumer();
        consumer.createItem(ts);
    }

    public void testGetAllItems() {
        TransactionConsumer consumer =injector.getConsumer();
        consumer.getAllItems();
    }

    public void testEditItem() {
        Transaction ts = new Transaction(null,500,null,parseDate("2023-01-17"));
        TransactionConsumer consumer =injector.getConsumer();
        consumer.editItem(1,ts);
    }

    public void testGetItem() {
        TransactionConsumer consumer =injector.getConsumer();
        consumer.getItem(1);
    }

    public void testIsValidItem() {
        TransactionConsumer consumer =injector.getConsumer();
        consumer.isValidItem(1);
    }

    public void testDeleteItem() {
        TransactionConsumer consumer =injector.getConsumer();
        consumer.deleteItem(1);
    }

    @After
    public void tear(){
        injector = null;
    }
}