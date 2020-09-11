package com.aneirine.userservice.api.users;

import com.aneirine.userservice.api.users.domain.UserData;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserAdditionalService userAdditionalService;

    public UserController(UserService userService, UserAdditionalService userAdditionalService) {
        this.userService = userService;
        this.userAdditionalService = userAdditionalService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody UserData userData) {
        return new ResponseEntity(userService.createUser(userData), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{userId}")
    public ResponseEntity getUserById(@PathVariable("userId") long userId) {
        return new ResponseEntity(userService.getUserById(userId), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity updateUserById(@RequestBody UserData data, @PathVariable("id") long id) {
        return new ResponseEntity(userService.updateUserById(id, data), HttpStatus.OK);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") long id){
        userService.deleteUserById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{userId}/transactions/{transactionId}")
    public ResponseEntity addTransactionToUser(@PathVariable("userId") long userId,
                                               @PathVariable("transactionId") long transactionId) {
        userAdditionalService.addTransactionToUser(userId, transactionId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{userId}/transactions")
    public ResponseEntity<List<Long>> getTransactionsIdByUserId(@PathVariable("userId") long userId) {
        return new ResponseEntity(userAdditionalService.getTransactionsIdByUserId(userId), HttpStatus.OK);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{userId}/jars/{jarId}")
    public ResponseEntity addJarToUser(@PathVariable("userId") long userId,
                                       @PathVariable("jarId") long jarId) {
        userAdditionalService.addJarToUser(userId, jarId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{userId}/vaults/{vaultId}")
    public ResponseEntity addVaultToUser(@PathVariable("userId") long userId,
                                         @PathVariable("vaultId") long vaultId) {
        userAdditionalService.addVaultToUser(userId, vaultId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{userId}/vaults")
    public ResponseEntity<List<Long>> getVaultsByUserId(@PathVariable("userId") long userId) {
        return new ResponseEntity(userAdditionalService.getVaultsByUserId(userId), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/vaults/{vaultId}")
    public ResponseEntity removeVaultFromUserById(@PathVariable("vaultId") long vaultId) {
        userAdditionalService.removeVaultFromUserById(vaultId);
        return new ResponseEntity(HttpStatus.OK);
    }


}
