package com.aneirine.transactionservice.api.transactions.category.domain;

import com.aneirine.transactionservice.entities.TransactionCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCategoryResponse {

    private long id;
    private String name;

    public TransactionCategoryResponse(TransactionCategory transactionCategory) {
        this.id = transactionCategory.getId();
        this.name = transactionCategory.getName();
    }
}
