package com.aneirine.moneyflow.api.transactions.main;

import com.aneirine.moneyflow.api.transactions.category.domain.TransactionCategoryData;
import com.aneirine.moneyflow.api.transactions.main.domain.TransactionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createTransaction(@Valid @RequestBody TransactionData data) {
        return new ResponseEntity(transactionService.createTransaction(data), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{transactionId}")
    public ResponseEntity getTransactionById(@PathVariable("transactionId") long transactionId) {
        return new ResponseEntity(transactionService.getTransactionById(transactionId), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{transactionId}")
    public ResponseEntity updateTransactionById(@PathVariable("transactionId") long transactionId,
                                                        @Valid @RequestBody TransactionData data) {
        return new ResponseEntity(transactionService.updateTransactionById(transactionId, data), HttpStatus.OK);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{transactionId}")
    public ResponseEntity deleteTransactionById(@PathVariable("transactionId") long transactionId) {
        transactionService.deleteTransactionById(transactionId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
