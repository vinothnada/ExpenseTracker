package com.expense.application.Injector;

import com.expense.application.Consumer.TransactionConsumer;
import com.expense.application.services.transaction.TransactionServiceImpl;

public class TransactionServiceInjector {

    public TransactionConsumer getConsumer(){
        TransactionConsumer app = new TransactionConsumer();
        app.setTransactionService(new TransactionServiceImpl());
        return app;
    }

}
