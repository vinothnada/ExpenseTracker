package com.expense.application.Injector;

import com.expense.application.Consumer.BudgetSetupConsumer;
import com.expense.application.services.budgetSetup.BudgetSetupServiceImpl;

public class BudgetSetupServiceInjector {

    public BudgetSetupConsumer getConsumer(){
        BudgetSetupConsumer app = new BudgetSetupConsumer();
        app.setBudgetSetupService(new BudgetSetupServiceImpl());
        return app;
    }

}
