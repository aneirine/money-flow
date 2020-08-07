package com.aneirine.moneyflow.api.transactions.category.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCategoryResponse {

    private long id;
    private String name;
}
