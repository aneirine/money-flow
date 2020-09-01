package com.aneirine.moneyflow.api.users;

import com.aneirine.moneyflow.api.users.domain.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createPerson(@RequestBody UserData userData) {
        return new ResponseEntity(userService.createUser(userData), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{userId}/transactions/{transactionId}")
    public ResponseEntity addTransactionToUser(@PathVariable("userId") long userId,
                                               @PathVariable("transactionId") long transactionId) {
        userService.addTransactionToUser(userId, transactionId);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{userId}/transactions")
    public ResponseEntity<List<Long>> getTransactionsIdByUserId(@PathVariable("userId") long userId) {
        return new ResponseEntity(userService.getTransactionsIdByUserId(userId), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{userId}/jars/{jarId}")
    public ResponseEntity addJarToUser(@PathVariable("userId") long userId,
                                               @PathVariable("jarId") long jarId) {
        userService.addJarToUser(userId, jarId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
