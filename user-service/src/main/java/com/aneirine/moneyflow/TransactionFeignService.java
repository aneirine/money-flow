package com.aneirine.moneyflow;

import com.aneirine.moneyflow.api.users.domain.TransactionIdsList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "transaction-service")
@RequestMapping("/api/transactions")
public interface TransactionFeignService {

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteTransactionById(@RequestBody TransactionIdsList data);

}
