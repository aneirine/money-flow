package com.aneirine.exceptionservice.api.transactions.main;

import com.aneirine.exceptionservice.api.feign.UserFeignService;
import com.aneirine.exceptionservice.api.transactions.category.TransactionCategoryRepository;
import com.aneirine.exceptionservice.api.transactions.main.domain.TransactionData;
import com.aneirine.exceptionservice.api.transactions.main.domain.TransactionIdsList;
import com.aneirine.exceptionservice.api.transactions.main.domain.TransactionResponse;
import com.aneirine.exceptionservice.entities.Transaction;
import com.aneirine.exceptionservice.entities.TransactionCategory;
import com.aneirine.exceptionservice.entities.TransactionType;
import com.aneirine.exceptionservice.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionCategoryRepository transactionCategoryRepository;
    private final UserFeignService userFeignService;

    public TransactionService(TransactionRepository transactionRepository, TransactionCategoryRepository transactionCategoryRepository, UserFeignService userFeignService) {
        this.transactionRepository = transactionRepository;
        this.transactionCategoryRepository = transactionCategoryRepository;
        this.userFeignService = userFeignService;
    }


    public TransactionResponse createTransaction(TransactionData data, long userId) {
        try {
            userFeignService.getUserById(userId);
        } catch (Exception e) {
            throw new NotFoundException("USER_NOT_FOUND");
        }

        TransactionType transactionType = TransactionType.getTransactionTypeByOrdinal(data.getTypeOrdinal());
        TransactionCategory transactionCategory = transactionCategoryRepository.findById(data.getCategoryId())
                .orElseThrow(() -> new NotFoundException("TRANSACTION_CATEGORY_NOT_FOUND"));
        Transaction transaction = new Transaction(
                data.getName(), data.getSum(), transactionType.ordinal(), transactionCategory
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
        ResponseEntity<List<Long>> response = userFeignService.getTransactionsIdByUserId(userId);
        List<TransactionResponse> responses = new ArrayList<>();

        List<Transaction> transactions = transactionRepository.findAllByIdIn(response.getBody());
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

        transaction.setTransactionType(transactionType.ordinal());
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

    public void deleteAllTransactionsByIds(TransactionIdsList data) {
        transactionRepository.deleteAllByIdIn(data.getTransactionIds());
    }


}
