package com.aneirine.userservice.api.feign;

import com.aneirine.userservice.api.users.domain.IdListData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "jar-service")
@RequestMapping("/api/jars")
public interface JarFeignService {


    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteJarsByIds(@RequestBody IdListData data);

}
