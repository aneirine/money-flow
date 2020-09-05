package com.aneirine.userservice.api.users.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TransactionIdsList {
    private List<Long> transactionIds;
}
