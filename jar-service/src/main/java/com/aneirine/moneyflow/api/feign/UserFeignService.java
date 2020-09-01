package com.aneirine.moneyflow.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user-service")
@RequestMapping("/api/users")
public interface UserFeignService {

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{userId}/jars/{jarId}")
    public ResponseEntity addJarToUser(@PathVariable("userId") long userId,
                                       @PathVariable("jarId") long jarId);


}