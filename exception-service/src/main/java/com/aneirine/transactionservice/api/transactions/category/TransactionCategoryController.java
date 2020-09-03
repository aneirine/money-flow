package com.aneirine.transactionservice.api.transactions.category;

import com.aneirine.transactionservice.api.transactions.category.domain.TransactionCategoryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/transactions/categories")
public class TransactionCategoryController {

    @Autowired
    private TransactionCategoryService transactionCategoryService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createTransactionCategory(@Valid @RequestBody TransactionCategoryData data) {
        return new ResponseEntity(transactionCategoryService.createTransactionCategory(data), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{transactionCategoryId}")
    public ResponseEntity getTransactionCategoryById(@PathVariable("transactionCategoryId") long transactionCategoryId) {
        return new ResponseEntity(transactionCategoryService.getTransactionCategoryById(transactionCategoryId), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{transactionCategoryId}")
    public ResponseEntity updateTransactionCategoryById(@PathVariable("transactionCategoryId") long transactionCategoryId,
                                                        @Valid @RequestBody TransactionCategoryData data) {
        return new ResponseEntity(transactionCategoryService.updateTransactionCategoryById(transactionCategoryId, data), HttpStatus.OK);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{transactionCategoryId}")
    public ResponseEntity deleteTransactionCategoryById(@PathVariable("transactionCategoryId") long transactionCategoryId) {
        transactionCategoryService.deleteTransactionCategoryById(transactionCategoryId);
        return new ResponseEntity(HttpStatus.OK);
    }


}
