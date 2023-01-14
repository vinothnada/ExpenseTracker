package com.expense.application.Consumer;

import com.expense.application.models.BudgetSetup;
import com.expense.application.services.budgetSetup.BudgetSetupService;

import java.util.List;

public class BudgetSetupConsumer{
    private BudgetSetupService budgetSetupService;

    public BudgetSetupConsumer() {}

    public BudgetSetupConsumer(BudgetSetupService budgetSetupService) {
        this.budgetSetupService = budgetSetupService;
    }

    public void setBudgetSetupService(BudgetSetupService budgetSetupService) {
        this.budgetSetupService = budgetSetupService;
    }

    public List<BudgetSetup> getAllItems(){
        return this.budgetSetupService.getAllItems();
    }

    public String createItem(BudgetSetup budgetSetup){
        return this.budgetSetupService.createItem(budgetSetup);
    }

    public String editItem(int itemId, BudgetSetup budgetSetup){
        return this.budgetSetupService.editItem(itemId,budgetSetup);
    }

    public String deleteItem(int itemId){
        return this.budgetSetupService.deleteItem(itemId);
    }


}
