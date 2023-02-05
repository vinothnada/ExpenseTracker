package com.expense.application.services.transaction;

import com.expense.application.models.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAllItems();
    String createItem(Transaction Transaction);
    String editItem(int itemId, Transaction transaction);
    String deleteItem(int itemId);

    boolean isValidItem(int itemId);

    Transaction getItem(int itemId);

    List<Transaction> getRecentItems();
}
