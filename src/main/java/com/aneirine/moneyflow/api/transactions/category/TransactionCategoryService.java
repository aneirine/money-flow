package com.aneirine.moneyflow.api.transactions.category;

import com.aneirine.moneyflow.api.transactions.category.domain.TransactionCategoryData;
import com.aneirine.moneyflow.api.transactions.category.domain.TransactionCategoryResponse;
import com.aneirine.moneyflow.entities.TransactionCategory;
import com.aneirine.moneyflow.exceptions.ConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionCategoryService {


    @Autowired
    private TransactionCategoryRepository transactionCategoryRepository;

    public TransactionCategoryResponse createTransactionCategory(TransactionCategoryData data){
        TransactionCategory transactionCategory = new TransactionCategory();
        if(transactionCategoryRepository.existsByName(data.getName())){
            throw new ConflictException("NAME_ALREADY_EXISTS");
        }
        transactionCategory.setName(data.getName());
        transactionCategoryRepository.save(transactionCategory);
        return new TransactionCategoryResponse(transactionCategory);

    }
}
