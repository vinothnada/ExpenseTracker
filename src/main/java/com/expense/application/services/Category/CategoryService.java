package com.expense.application.services.Category;

import com.expense.application.models.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllItems();

    String createItem(Category category);

    String editItem(int itemId, Category category);

    String deleteItem(int itemId);

    Category getItem(int itemId);

    Boolean isValidItem(int itemId);
}
