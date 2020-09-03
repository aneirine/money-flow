package com.aneirine.transactionservice.api.transactions.category.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TransactionCategoryData {

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 30, message = "The min value is 2, the max is 30")
    private String name;
}
