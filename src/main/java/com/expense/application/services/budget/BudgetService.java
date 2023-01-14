package com.expense.application.services.budget;

import com.expense.application.models.BudgetData;

import java.util.List;
import java.util.stream.Collectors;

public interface BudgetService {

    public List<BudgetData> getAllItems();

    public String createItem(BudgetData budgetData);

    public String editItem(int itemId, BudgetData budgetData);

    public String deleteItem(int itemId);

    public BudgetData getItem(int itemId);

    public Boolean isValidItem(int itemId);

}
