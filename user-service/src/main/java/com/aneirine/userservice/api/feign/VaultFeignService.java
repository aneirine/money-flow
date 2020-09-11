package com.aneirine.userservice.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "vault-service")
@RequestMapping("/api/vaults")
public interface VaultFeignService {




}
