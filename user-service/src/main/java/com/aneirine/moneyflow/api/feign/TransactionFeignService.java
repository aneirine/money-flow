package com.aneirine.moneyflow.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "transaction-service")
@RequestMapping("/api/transactions")
public interface TransactionFeignService {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/test/{userId}")
    public ResponseEntity creteTestTransactionWithUserId(@PathVariable("userId") long userId);


}