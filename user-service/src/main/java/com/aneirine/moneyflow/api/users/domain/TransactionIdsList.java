package com.aneirine.moneyflow.api.users.domain;

import lombok.Data;

import java.util.List;

@Data
public class TransactionIdsList {
    private List<Long> transactionIds;
}
