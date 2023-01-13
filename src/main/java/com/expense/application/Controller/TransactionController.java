package com.expense.application.Controller;

import com.expense.application.models.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionController {
    List<Transaction> tarnsactionList = new ArrayList<>();

    public List<Transaction> getAllItems(){
        return tarnsactionList;
    }

    public String createItem(Transaction Transaction){
        if(tarnsactionList.size() == 0 ){
            Transaction.setId(1);
        }else{
            Transaction bs = tarnsactionList.get(tarnsactionList.size() - 1);
            Transaction.setId(bs.getId() + 1);
        }
        tarnsactionList.add(Transaction);
        return "Transaction Created Successfully";
    }

    public String editItem(int itemId, Transaction transaction){
        Transaction transactionItem = tarnsactionList.stream().filter(a -> a.getId() == itemId).collect(Collectors.toList()).get(0);
        tarnsactionList.removeIf(e -> e.getId() == itemId);
        transactionItem.setTransactionType(transaction.getTransactionType());
        transactionItem.setAmount(transaction.getAmount());
        transactionItem.setCategory(transaction.getCategory());
        transactionItem.setTrasactionDate(transaction.getTrasactionDate());
        tarnsactionList.add(transactionItem);
        return "Transaction updated Successfully";
    }

    public String deleteItem(int itemId){
        tarnsactionList.removeIf(e -> e.getId() == itemId);
        return "Transaction deleted Successfully";
    }
}
