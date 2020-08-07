package com.aneirine.moneyflow.api.transactions.category;

import com.aneirine.moneyflow.api.transactions.category.domain.TransactionCategoryData;
import com.aneirine.moneyflow.api.transactions.category.domain.TransactionCategoryResponse;
import com.aneirine.moneyflow.entities.TransactionCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionCategoryService {


    @Autowired
    private TransactionCategoryRepository transactionCategoryRepository;

    public TransactionCategoryResponse createTransactionCategory(TransactionCategoryData data){
        TransactionCategory transactionCategory = new TransactionCategory();
        transactionCategory.setName(data.getName());

    }
}
