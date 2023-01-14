package com.expense.application.Controller;

import com.expense.application.models.BudgetData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BudgetController {

    List<BudgetData> budgetDataList = new ArrayList<>();

    public List<BudgetData> getAllItems() {
        return budgetDataList;
    }

    public String createItem(BudgetData budgetData) {
        if (budgetDataList.size() == 0) {
            budgetData.setId(1);
        } else {
            BudgetData bs = budgetDataList.get(budgetDataList.size() - 1);
            budgetData.setId(bs.getId() + 1);
        }
        budgetDataList.add(budgetData);
        return "BudgetData Created Successfully";
    }

    public String editItem(int itemId, BudgetData budgetData) {
        BudgetData bDataItem = budgetDataList.stream().filter(a -> a.getId() == itemId).collect(Collectors.toList())
                .get(0);
        budgetDataList.removeIf(e -> e.getId() == itemId);
        bDataItem.setBudgetSetup(budgetData.getBudgetSetup());
        bDataItem.setAmount(budgetData.getAmount());
        bDataItem.setCategory(budgetData.getCategory());
        budgetDataList.add(bDataItem);
        return "BudgetData updated Successfully";
    }

    public String deleteItem(int itemId) {
        budgetDataList.removeIf(e -> e.getId() == itemId);
        return "BudgetData deleted Successfully";
    }

    public BudgetData getItem(int itemId) {
        return budgetDataList.stream().filter(a -> a.getId() == itemId).collect(Collectors.toList()).get(0);
    }

    public Boolean isValidItem(int itemId) {
        return budgetDataList.stream().anyMatch(a -> a.getId() == itemId);
    }
}
