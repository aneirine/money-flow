package com.aneirine.vaultservice.api.feign;

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

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{userId}/vaults/{vaultId}")
    public ResponseEntity addVaultToUser(@PathVariable("userId") long userId,
                                         @PathVariable("vaultId") long vaultId);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{userId}")
    public ResponseEntity getUserById(@PathVariable("userId") long userId);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{userId}/vaults")
    public ResponseEntity<List<Long>> getVaultsByUserId(@PathVariable("userId") long userId);


}
