package com.expense.application.services.budgetSetup;

import com.expense.application.models.BudgetData;
import com.expense.application.models.BudgetSetup;

import java.util.List;

public interface BudgetSetupService {

    public List<BudgetSetup> getAllItems();

    public String createItem(BudgetSetup budgetSetup);

    public String editItem(int itemId, BudgetSetup budgetSetup);

    public String deleteItem(int itemId);
}
