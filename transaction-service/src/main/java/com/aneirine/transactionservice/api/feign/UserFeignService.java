package com.aneirine.transactionservice.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "user-service")
@RequestMapping("/api/users")
public interface UserFeignService {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{userId}/transactions")
    public ResponseEntity<List<Long>> getTransactionsIdByUserId(@PathVariable("userId") long userId);

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{userId}/transactions/{transactionId}")
    public ResponseEntity addTransactionToUser(@PathVariable("userId") long userId,
                                               @PathVariable("transactionId") long transactionId);


}
