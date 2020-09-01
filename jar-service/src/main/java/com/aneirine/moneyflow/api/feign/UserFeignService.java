package com.aneirine.moneyflow.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user-service")
@RequestMapping("/api/users")
public interface UserFeignService {



}
