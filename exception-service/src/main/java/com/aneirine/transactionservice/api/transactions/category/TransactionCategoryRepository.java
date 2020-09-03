package com.aneirine.transactionservice.api.transactions.category;


import com.aneirine.transactionservice.entities.TransactionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionCategoryRepository extends JpaRepository<TransactionCategory, Long> {

    boolean existsByName(String name);
}
