package com.expense.application.services.transaction;

import com.expense.application.models.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface TransactionService {
    public List<Transaction> getAllItems();
    public String createItem(Transaction Transaction);
    public String editItem(int itemId, Transaction transaction);
    public String deleteItem(int itemId);

    public boolean isValidItem(int itemId);

    public Transaction getItem(int itemId);

    public List<Transaction> getRecentItems();
}
