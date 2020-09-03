package com.aneirine.exceptionservice.api.transactions.main.domain;

import lombok.Data;

import java.util.List;

@Data
public class TransactionIdsList {

    private List<Long> transactionIds;
}
