package com.expense.application.Injector;

import com.expense.application.Consumer.BudgetConsumer;
import com.expense.application.services.budget.BudgetServiceImpl;

public class BudgetServiceInjector {

    public BudgetConsumer getConsumer(){
        BudgetConsumer app = new BudgetConsumer();
        app.setBudgetService(new BudgetServiceImpl());
        return app;
    }

}
