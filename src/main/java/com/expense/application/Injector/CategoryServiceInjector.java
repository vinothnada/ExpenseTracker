package com.expense.application.Injector;

import com.expense.application.Consumer.CategoryConsumer;
import com.expense.application.services.Category.CategoryServiceImpl;

public class CategoryServiceInjector {

    public CategoryConsumer getConsumer(){
        CategoryConsumer app = new CategoryConsumer();
        app.setCategoryService(new CategoryServiceImpl());
        return app;
    }

}
