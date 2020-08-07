package com.aneirine.moneyflow.api.transactions.category;

import com.aneirine.moneyflow.api.transactions.category.domain.TransactionCategoryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/transactions/categories")
public class TransactionCategoryController {

    @Autowired
    private TransactionCategoryService transactionCategoryService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createTransactionCategory(@Valid @RequestBody TransactionCategoryData data){
        return new ResponseEntity(transactionCategoryService.createTransactionCategory(data), HttpStatus.OK);
    }
}
