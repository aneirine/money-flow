package com.aneirine.transactionservice.api.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "user-service")
public interface UserFeignService {


}
