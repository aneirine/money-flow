package com.aneirine.moneyflow.api.transactions.main.domain;

import com.aneirine.moneyflow.entities.Transaction;
import com.aneirine.moneyflow.entities.enums.TransactionType;
import lombok.Data;

@Data
public class TransactionResponse {

    private String name;
    private double sum;
    private TransactionType transactionType;
    private String categoryName;

    public TransactionResponse(Transaction transaction) {
        this.name = transaction.getName();
        this.sum = transaction.getSum();
        this.transactionType = transaction.getTransactionType();
        this.categoryName = transaction.getTransactionCategory().getName();
    }
}
