package com.aneirine.moneyflow.api.transactions.category;

import com.aneirine.moneyflow.entities.TransactionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionCategoryRepository extends JpaRepository<TransactionCategory, Long> {
}
