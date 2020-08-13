package com.aneirine.moneyflow.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "transaction-service")
@RequestMapping("/api/transactions")
public interface TransactionFeignService {



}