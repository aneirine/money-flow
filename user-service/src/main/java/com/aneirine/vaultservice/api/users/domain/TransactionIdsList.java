package com.aneirine.vaultservice.api.users.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TransactionIdsList {
    private List<Long> transactionIds;
}
