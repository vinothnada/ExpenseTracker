package com.expense.application.services.budget;

import com.expense.application.models.BudgetData;

import java.util.List;
import java.util.stream.Collectors;

public interface BudgetService {

    List<BudgetData> getAllItems();

    String createItem(BudgetData budgetData);

    String editItem(int itemId, BudgetData budgetData);

    String deleteItem(int itemId);

    BudgetData getItem(int itemId);

    Boolean isValidItem(int itemId);

}
