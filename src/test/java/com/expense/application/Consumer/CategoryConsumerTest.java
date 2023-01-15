package com.expense.application.Consumer;

import com.expense.application.Injector.CategoryServiceInjector;
import com.expense.application.models.Category;
import com.expense.application.services.Category.CategoryServiceImpl;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class CategoryConsumerTest extends TestCase {

    private CategoryServiceInjector injector;
    @Before
    public void setUp(){
        //mock the injector with anonymous class
        injector = new CategoryServiceInjector() {

            @Override
            public CategoryConsumer getConsumer() {
                //mock the message service
                return new CategoryConsumer(new CategoryServiceImpl() {

                    List<Category> budgetDataList = new ArrayList<>();

                    @Override
                    public String createItem(Category budgetData) {
                        budgetDataList.add(budgetData);
                        return "Category Created Successfully";
                    }

                    @Override
                    public String editItem(int id , Category budgetData) {
                        return "Category updated Successfully";
                    }

                    @Override
                    public Category getItem(int id) {
                        return new Category();
                    }
                });
            }
        };
    }


    public void testCreateItem() {
        Category budgetData = new Category("Cloths","cloths for offices");
        CategoryConsumer consumer =injector.getConsumer();
        consumer.createItem(budgetData);
    }

    public void testGetAllItems() {
        CategoryConsumer consumer =injector.getConsumer();
        consumer.getAllItems();
    }

    public void testEditItem() {
        Category budgetData = new Category("Cloths","cloths for offices");
        CategoryConsumer consumer =injector.getConsumer();
        consumer.editItem(1,budgetData);
    }

    public void testGetItem() {
        CategoryConsumer consumer =injector.getConsumer();
        consumer.getItem(1);
    }

    public void testIsValidItem() {
        CategoryConsumer consumer =injector.getConsumer();
        consumer.isValidItem(1);
    }

    public void testDeleteItem() {
        CategoryConsumer consumer =injector.getConsumer();
        consumer.deleteItem(1);
    }

    @After
    public void tear(){
        injector = null;
    }
}