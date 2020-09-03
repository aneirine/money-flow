package com.aneirine.exceptionservice.api.transactions.main;

import com.aneirine.exceptionservice.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByIdIn(List<Long> ids);

    void deleteAllByIdIn(List<Long> ids);
}
