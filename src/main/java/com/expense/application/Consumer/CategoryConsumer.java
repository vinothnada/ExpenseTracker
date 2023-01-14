package com.expense.application.Consumer;

import com.expense.application.models.BudgetData;
import com.expense.application.models.Category;
import com.expense.application.services.Category.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryConsumer{
    private CategoryService categoryService;

    public CategoryConsumer() {}

    public CategoryConsumer(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public List<Category> getAllItems(){
        return this.categoryService.getAllItems();
    }

    public String createItem(Category category){
        return this.categoryService.createItem(category);
    }

    public String editItem(int itemId, Category category){
        return this.categoryService.editItem(itemId,category);
    }

    public String deleteItem(int itemId){
        return this.categoryService.deleteItem(itemId);
    }

    public Category getItem(int itemId){
        return this.categoryService.getItem(itemId);
    }

    public Boolean isValidItem(int itemId){
        return this.categoryService.isValidItem(itemId);
    }


}
