package com.expense.application.Consumer;

import com.expense.application.models.Transaction;
import com.expense.application.services.transaction.TransactionService;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionConsumer{

    private TransactionService transactionService;

    public TransactionConsumer() {}

    public TransactionConsumer(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public List<Transaction> getAllItems(){
        return this.transactionService.getAllItems();
    }

    public String createItem(Transaction transaction){
        return this.transactionService.createItem(transaction);
    }

    public String editItem(int itemId, Transaction transaction){
        return this.transactionService.editItem(itemId,transaction);
    }

    public String deleteItem(int itemId){
        return this.transactionService.deleteItem(itemId);
    }

    public boolean isValidItem(int itemId){
        return this.transactionService.isValidItem(itemId);
    }

    public Transaction getItem(int itemId) {
        return this.transactionService.getItem(itemId);
    }
    public List<Transaction> getRecentItems() {
        return this.transactionService.getRecentItems();
    }
}
