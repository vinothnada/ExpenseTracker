package com.expense.application.Controller;

import com.expense.application.models.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionController {
    List<Transaction> transactionList = new ArrayList<>();

    public List<Transaction> getAllItems() {
        return transactionList;
    }

    public String createItem(Transaction Transaction) {
        if (transactionList.size() == 0) {
            Transaction.setId(1);
        } else {
            Transaction bs = transactionList.get(transactionList.size() - 1);
            Transaction.setId(bs.getId() + 1);
        }
        transactionList.add(Transaction);
        return "Transaction Created Successfully";
    }

    public String editItem(int itemId, Transaction transaction) {
        Transaction transactionItem = transactionList.stream().filter(a -> a.getId() == itemId)
                .collect(Collectors.toList()).get(0);
        transactionList.removeIf(e -> e.getId() == itemId);
        transactionItem.setTransactionType(transaction.getTransactionType());
        transactionItem.setAmount(transaction.getAmount());
        transactionItem.setCategory(transaction.getCategory());
        transactionItem.setTransactionDate(transaction.getTransactionDate());
        transactionList.add(transactionItem);
        return "Transaction updated Successfully";
    }

    public String deleteItem(int itemId) {
        transactionList.removeIf(e -> e.getId() == itemId);
        return "Transaction deleted Successfully";
    }

    public boolean isValidItem(int itemId) {
        return transactionList.stream().anyMatch(e -> e.getId() == itemId);
    }

    public Transaction getItem(int itemId) {
        return transactionList.stream().filter(a -> a.getId() == itemId).collect(Collectors.toList()).get(0);
    }

    public List<Transaction> getRecentItems() {
        List<Transaction> lastTenTransactions = transactionList.stream()
                .skip(Math.max(0, transactionList.size() - 10))
                .collect(Collectors.toList());
        return lastTenTransactions;
    }

}
