package com.expense.application.services.transaction;

import com.expense.application.models.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionServiceImpl implements TransactionService{
    List<Transaction> transactionList = new ArrayList<>();

    @Override
    public List<Transaction> getAllItems(){
        return transactionList;
    }

    @Override
    public String createItem(Transaction Transaction){
        if(transactionList.size() == 0 ){
            Transaction.setId(1);
        }else{
            Transaction bs = transactionList.get(transactionList.size() - 1);
            Transaction.setId(bs.getId() + 1);
        }
        transactionList.add(Transaction);
        return "Transaction Created Successfully";
    }

    @Override
    public String editItem(int itemId, Transaction transaction){
        Transaction transactionItem = transactionList.stream().filter(a -> a.getId() == itemId).collect(Collectors.toList()).get(0);
        transactionList.removeIf(e -> e.getId() == itemId);
        transactionItem.setTransactionType(transaction.getTransactionType());
        transactionItem.setAmount(transaction.getAmount());
        transactionItem.setCategory(transaction.getCategory());
        transactionItem.setTrasactionDate(transaction.getTrasactionDate());
        transactionList.add(transactionItem);
        return "Transaction updated Successfully";
    }

    @Override
    public String deleteItem(int itemId){
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
