package com.expense.application.services.Category;

import com.expense.application.models.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService{
    List<Category> categoryList = new ArrayList<>(Arrays.asList(
            new Category(1,"Salary","Salary Description",true,30),
            new Category(2,"Cloths","Cloths Description",false,0),
            new Category(3,"Fuel","Fuel Description",true,7),
            new Category(4,"Gifts","Gifts Description",false,0),
            new Category(5,"Shops","Shops Description",false,0)
    ));

    @Override
    public List<Category> getAllItems(){
        return categoryList;
    }

    @Override
    public String createItem(Category category){
        Category c = categoryList.get(categoryList.size() - 1);
        category.setId(c.getId() + 1);
        categoryList.add(category);
        return "Category Created Successfully";
    }

    @Override
    public String editItem(int itemId, Category category){
        Category catItem = categoryList.stream().filter(a -> a.getId() == itemId).collect(Collectors.toList()).get(0);
        categoryList.removeIf(e -> e.getId() == itemId);
        catItem.setName(category.getName());
        catItem.setDescription(category.getDescription());
        categoryList.add(catItem);
        return "Category updated Successfully";
    }

    @Override
    public String deleteItem(int itemId){
        categoryList.removeIf(e -> e.getId() == itemId);
        return "Category deleted Successfully";
    }

    @Override
    public Category getItem(int itemId) {
        return categoryList.stream().filter(a -> a.getId() == itemId).collect(Collectors.toList()).get(0);
    }

    @Override
    public Boolean isValidItem(int itemId) {
        return categoryList.stream().anyMatch(a -> a.getId() == itemId);
    }    
}
