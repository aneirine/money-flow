package com.aneirine.moneyflow.api.transactions.main;

import com.aneirine.moneyflow.api.transactions.category.TransactionCategoryRepository;
import com.aneirine.moneyflow.api.transactions.main.domain.TransactionData;
import com.aneirine.moneyflow.api.transactions.main.domain.TransactionResponse;
import com.aneirine.moneyflow.entities.Transaction;
import com.aneirine.moneyflow.entities.TransactionCategory;
import com.aneirine.transactionservice.entities.enums.TransactionType;
import com.aneirine.moneyflow.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionCategoryRepository transactionCategoryRepository;


    public TransactionResponse createTransaction(TransactionData data) {
        TransactionType transactionType = TransactionType.getTransactionTypeByOrdinal(data.getTypeOrdinal());
        TransactionCategory transactionCategory = transactionCategoryRepository.findById(data.getCategoryId())
                .orElseThrow(() -> new NotFoundException("TRANSACTION_CATEGORY_NOT_FOUND"));
        Transaction transaction = new Transaction(
                data.getName(), data.getSum(), transactionType, transactionCategory
        );
        transactionRepository.save(transaction);
        return new TransactionResponse(transaction);
    }

    public TransactionResponse getTransactionById(long id) {
        return new TransactionResponse(transactionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("TRANSACTION_NOT_FOUND")));
    }

    public TransactionResponse updateTransactionById(long id, TransactionData data) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("TRANSACTION_NOT_FOUND"));
        TransactionType transactionType = TransactionType.getTransactionTypeByOrdinal(data.getTypeOrdinal());
        TransactionCategory transactionCategory = transactionCategoryRepository.findById(data.getCategoryId())
                .orElseThrow(() -> new NotFoundException("TRANSACTION_CATEGORY_NOT_FOUND"));

        transaction.setTransactionType(transactionType);
        transaction.setTransactionCategory(transactionCategory);
        transaction.setSum(data.getSum());
        transaction.setName(data.getName());

        transactionRepository.save(transaction);
        return new TransactionResponse(transaction);
    }

    public void deleteTransactionById(long id){
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("TRANSACTION_NOT_FOUND"));
        transactionRepository.deleteById(id);
    }
}
