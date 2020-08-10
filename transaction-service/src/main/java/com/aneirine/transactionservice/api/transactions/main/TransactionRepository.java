package com.aneirine.transactionservice.api.transactions.main;

import com.aneirine.transactionservice.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
