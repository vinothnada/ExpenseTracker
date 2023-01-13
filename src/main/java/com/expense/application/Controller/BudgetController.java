package com.expense.application.Controller;

import com.expense.application.models.BudgetData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BudgetController {

    List<BudgetData> budgetDataList = new ArrayList<>();

    public List<BudgetData> getAllItems(){
        return budgetDataList;
    }

    public String createItem(BudgetData BudgetData){
        if(budgetDataList.size() == 0 ){
            BudgetData.setId(1);
        }else{
            BudgetData bs = budgetDataList.get(budgetDataList.size() - 1);
            BudgetData.setId(bs.getId() + 1);
        }
        budgetDataList.add(BudgetData);
        return "BudgetData Created Successfully";
    }

    public String editItem(int itemId, BudgetData BudgetData){
        BudgetData bDataItem = budgetDataList.stream().filter(a -> a.getId() == itemId).collect(Collectors.toList()).get(0);
        budgetDataList.removeIf(e -> e.getId() == itemId);
        bDataItem.setBudgetSetup(BudgetData.getBudgetSetup());
        bDataItem.setAmount(BudgetData.getAmount());
        bDataItem.setCategory(BudgetData.getCategory());
        budgetDataList.add(bDataItem);
        return "BudgetData updated Successfully";
    }

    public String deleteItem(int itemId){
        budgetDataList.removeIf(e -> e.getId() == itemId);
        return "BudgetData deleted Successfully";
    }

}
