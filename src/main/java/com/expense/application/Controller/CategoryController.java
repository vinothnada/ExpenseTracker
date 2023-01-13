package com.expense.application.Controller;

import com.expense.application.models.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryController {

    List<Category> categoryList = new ArrayList<>(Arrays.asList(
            new Category(1,"Salary","Salary Description"),
            new Category(2,"Cloths","Cloths Description"),
            new Category(3,"Fuel","Fuel Description"),
            new Category(4,"Gifts","Gifts Description"),
            new Category(5,"Shops","Shops Description")
    ));

    public List<Category> getAllItems(){
        return categoryList;
    }

    public String createItem(Category category){
        Category c = categoryList.get(categoryList.size() - 1);
        category.setId(c.getId() + 1);
        categoryList.add(category);
        return "Category Created Successfully";
    }

    public String editItem(int itemId, Category category){
        Category catItem = categoryList.stream().filter(a -> a.getId() == itemId).collect(Collectors.toList()).get(0);
        categoryList.removeIf(e -> e.getId() == itemId);
        catItem.setName(category.getName());
        catItem.setDescription(category.getDescription());
        categoryList.add(catItem);
        return "Category updated Successfully";
    }

    public String deleteItem(int itemId){
        categoryList.removeIf(e -> e.getId() == itemId);
        return "Category deleted Successfully";
    }
}
