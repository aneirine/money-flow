package com.aneirine.transactionservice.api.transactions.main;

import com.aneirine.transactionservice.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByIdIn(List<Long> ids);

    void deleteAllByIdIn(List<Long> ids);
}
