package com.aneirine.exceptionservice.api.transactions.category;


import com.aneirine.exceptionservice.entities.TransactionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionCategoryRepository extends JpaRepository<TransactionCategory, Long> {

    boolean existsByName(String name);
}
