package com.aneirine.moneyflow.api.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "transaction-service")
public interface TransactionFeignService {
}
