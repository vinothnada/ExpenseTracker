package com.expense.application.Controller;

import com.expense.application.models.BudgetSetup;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BudgetSetupController {
    List<BudgetSetup> budgetSetupList = new ArrayList<>();

    public List<BudgetSetup> getAllItems(){
        return budgetSetupList;
    }

    public String createItem(BudgetSetup budgetSetup){
        if(budgetSetupList.size() == 0 ){
            budgetSetup.setId(1);
        }else{
            BudgetSetup bs = budgetSetupList.get(budgetSetupList.size() - 1);
            budgetSetup.setId(bs.getId() + 1);
        }
        budgetSetupList.add(budgetSetup);
        return "BudgetSetup Created Successfully";
    }

    public String editItem(int itemId, BudgetSetup budgetSetup){
        BudgetSetup bSetupItem = budgetSetupList.stream().filter(a -> a.getId() == itemId).collect(Collectors.toList()).get(0);
        budgetSetupList.removeIf(e -> e.getId() == itemId);
        bSetupItem.setName(budgetSetup.getName());
        bSetupItem.setBudgetType(budgetSetup.getBudgetType());
        budgetSetupList.add(bSetupItem);
        return "BudgetSetup updated Successfully";
    }

    public String deleteItem(int itemId){
        budgetSetupList.removeIf(e -> e.getId() == itemId);
        return "BudgetSetup deleted Successfully";
    }
}
