package com.expense.application.Consumer;

import com.expense.application.models.BudgetData;
import com.expense.application.services.budget.BudgetService;

import java.util.List;

public class BudgetConsumer{
    private BudgetService budgetService;

    public BudgetConsumer() {}

    public BudgetConsumer(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    public void setBudgetService(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    public List<BudgetData> getAllItems(){
        return this.budgetService.getAllItems();
    }

    public String createItem(BudgetData budgetData){
        return this.budgetService.createItem(budgetData);
    }

    public String editItem(int itemId, BudgetData budgetData){
        return this.budgetService.editItem(itemId,budgetData);
    }

    public String deleteItem(int itemId){
        return this.budgetService.deleteItem(itemId);
    }

    public BudgetData getItem(int itemId) {
        return this.budgetService.getItem(itemId);
    }

    public Boolean isValidItem(int itemId) {
        return this.budgetService.isValidItem(itemId);
    }


}
