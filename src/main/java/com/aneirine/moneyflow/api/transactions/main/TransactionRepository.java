package com.aneirine.moneyflow.api.transactions.main;

import com.aneirine.moneyflow.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
