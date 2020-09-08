package com.aneirine.vaultservice.api.vaults;

import com.aneirine.vaultservice.api.vaults.domain.VaultData;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vaults")
public class VaultController {

    private final VaultService vaultService;

    public VaultController(VaultService vaultService) {
        this.vaultService = vaultService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createVault(@RequestBody VaultData data) {
        return new ResponseEntity(vaultService.createVault(data), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity getVaultById(@PathVariable("id") long id){
        return new ResponseEntity(vaultService.getVaultById(id), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/users/{userId}")
    public ResponseEntity getVaultsByUserId(@PathVariable("userId") long userId){
        return new ResponseEntity(vaultService.getVaultsByUserId(userId), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity updateVaultById(@PathVariable("id") long id, @RequestBody VaultData data){
        return new ResponseEntity(vaultService.updateVaultResponseById(id, data), HttpStatus.OK);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity deleteVaultById(@PathVariable("id") long id){
        vaultService.deleteVaultById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
