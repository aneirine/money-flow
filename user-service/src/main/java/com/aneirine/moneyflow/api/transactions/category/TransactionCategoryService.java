package com.aneirine.moneyflow.api.transactions.category;

import com.aneirine.moneyflow.api.transactions.category.domain.TransactionCategoryData;
import com.aneirine.moneyflow.api.transactions.category.domain.TransactionCategoryResponse;
import com.aneirine.moneyflow.entities.TransactionCategory;
import com.aneirine.moneyflow.exceptions.ConflictException;
import com.aneirine.moneyflow.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionCategoryService {


    @Autowired
    private TransactionCategoryRepository transactionCategoryRepository;

    public TransactionCategoryResponse createTransactionCategory(TransactionCategoryData data) {
        TransactionCategory category = new TransactionCategory();
        if (transactionCategoryRepository.existsByName(data.getName())) {
            throw new ConflictException("NAME_ALREADY_EXISTS");
        }
        category.setName(data.getName());
        transactionCategoryRepository.save(category);
        return new TransactionCategoryResponse(category);
    }

    public TransactionCategoryResponse getTransactionCategoryById(long id) {
        return new TransactionCategoryResponse(transactionCategoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("TRANSACTION_CATEGORY_NOT_FOUND")));
    }

    public TransactionCategoryResponse updateTransactionCategoryById(long id, TransactionCategoryData data) {
        TransactionCategory category = transactionCategoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("TRANSACTION_CATEGORY_NOT_FOUND"));
        if (transactionCategoryRepository.existsByName(data.getName())) {
            throw new ConflictException("NAME_ALREADY_EXISTS");
        }
        category.setName(data.getName());
        transactionCategoryRepository.save(category);
        return new TransactionCategoryResponse(category);
    }

    public void deleteTransactionCategoryById(long id) {
        transactionCategoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("TRANSACTION_CATEGORY_NOT_FOUND"));
        transactionCategoryRepository.deleteById(id);
    }
}
