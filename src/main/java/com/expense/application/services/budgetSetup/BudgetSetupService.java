package com.expense.application.services.budgetSetup;

import com.expense.application.models.BudgetSetup;

import java.util.List;

public interface BudgetSetupService {

    List<BudgetSetup> getAllItems();

    String createItem(BudgetSetup budgetSetup);

    String editItem(int itemId, BudgetSetup budgetSetup);

    String deleteItem(int itemId);
}
