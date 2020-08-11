package com.aneirine.transactionservice.api.transactions.main;

import com.aneirine.transactionservice.api.feign.UserFeignService;
import com.aneirine.transactionservice.api.transactions.category.TransactionCategoryRepository;
import com.aneirine.transactionservice.api.transactions.main.domain.TransactionData;
import com.aneirine.transactionservice.api.transactions.main.domain.TransactionResponse;
import com.aneirine.transactionservice.entities.Transaction;
import com.aneirine.transactionservice.entities.TransactionCategory;
import com.aneirine.transactionservice.entities.TransactionType;
import com.aneirine.transactionservice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionCategoryRepository transactionCategoryRepository;

    @Autowired
    private UserFeignService userFeignService;


    public TransactionResponse createTransaction(TransactionData data, long userId) {
        TransactionType transactionType = TransactionType.getTransactionTypeByOrdinal(data.getTypeOrdinal());
        TransactionCategory transactionCategory = transactionCategoryRepository.findById(data.getCategoryId())
                .orElseThrow(() -> new NotFoundException("TRANSACTION_CATEGORY_NOT_FOUND"));
        Transaction transaction = new Transaction(
                data.getName(), data.getSum(), transactionType, transactionCategory
        );
        transactionRepository.save(transaction);
        userFeignService.addTransactionToUser(userId, transaction.getId());
        return new TransactionResponse(transaction);
    }

    public TransactionResponse getTransactionById(long id) {
        return new TransactionResponse(transactionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("TRANSACTION_NOT_FOUND")));
    }

    public List<TransactionResponse> getTransactionsByUserId(long userId) {
        List<Long> ids = (List<Long>) userFeignService.getTransactionsIdByUserId(userId);
        List<TransactionResponse> responses = new ArrayList<>();

        List<Transaction> transactions = transactionRepository.findAllByIdIn(ids);
        for (Transaction temp : transactions) {
            responses.add(new TransactionResponse(temp));
        }

        return responses;
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

    public void deleteTransactionById(long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("TRANSACTION_NOT_FOUND"));
        transactionRepository.deleteById(id);
    }
}
