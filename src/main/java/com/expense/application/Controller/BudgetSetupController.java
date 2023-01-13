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

    public String createItem(BudgetSetup BudgetSetup){
        if(budgetSetupList.size() == 0 ){
            BudgetSetup.setId(1);
        }else{
            BudgetSetup bs = budgetSetupList.get(budgetSetupList.size() - 1);
            BudgetSetup.setId(bs.getId() + 1);
        }
        budgetSetupList.add(BudgetSetup);
        return "BudgetSetup Created Successfully";
    }

    public String editItem(int itemId, BudgetSetup BudgetSetup){
        BudgetSetup bSetupItem = budgetSetupList.stream().filter(a -> a.getId() == itemId).collect(Collectors.toList()).get(0);
        budgetSetupList.removeIf(e -> e.getId() == itemId);
        bSetupItem.setName(BudgetSetup.getName());
        bSetupItem.setBudgetType(BudgetSetup.getBudgetType());
        budgetSetupList.add(bSetupItem);
        return "BudgetSetup updated Successfully";
    }

    public String deleteItem(int itemId){
        budgetSetupList.removeIf(e -> e.getId() == itemId);
        return "BudgetSetup deleted Successfully";
    }
}
