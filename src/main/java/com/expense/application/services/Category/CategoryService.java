package com.expense.application.services.Category;

import com.expense.application.models.BudgetData;
import com.expense.application.models.Category;

import java.util.List;
import java.util.stream.Collectors;

public interface CategoryService {

    public List<Category> getAllItems();

    public String createItem(Category category);

    public String editItem(int itemId, Category category);

    public String deleteItem(int itemId);

    public Category getItem(int itemId);

    public Boolean isValidItem(int itemId);
}
