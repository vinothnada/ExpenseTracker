package com.expense.application.services.budgetSetup;

import com.expense.application.models.BudgetSetup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BudgetSetupServiceImpl implements BudgetSetupService{
    List<BudgetSetup> budgetSetupList = new ArrayList<>();

    @Override
    public List<BudgetSetup> getAllItems(){
        return budgetSetupList;
    }

    @Override
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

    @Override
    public String editItem(int itemId, BudgetSetup budgetSetup){
        BudgetSetup bSetupItem = budgetSetupList.stream().filter(a -> a.getId() == itemId).collect(Collectors.toList()).get(0);
        budgetSetupList.removeIf(e -> e.getId() == itemId);
        bSetupItem.setName(budgetSetup.getName());
        bSetupItem.setBudgetType(budgetSetup.getBudgetType());
        budgetSetupList.add(bSetupItem);
        return "BudgetSetup updated Successfully";
    }

    @Override
    public String deleteItem(int itemId){
        budgetSetupList.removeIf(e -> e.getId() == itemId);
        return "BudgetSetup deleted Successfully";
    }
}
