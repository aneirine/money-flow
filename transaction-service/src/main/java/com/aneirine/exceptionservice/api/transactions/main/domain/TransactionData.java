package com.aneirine.exceptionservice.api.transactions.main.domain;

import lombok.Data;

@Data
public class TransactionData {

    private String name;
    private double sum;
    private int typeOrdinal;
    private long categoryId;

}
