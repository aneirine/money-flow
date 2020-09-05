package com.aneirine.vaultservice.api.vaults;

import org.springframework.stereotype.Service;

@Service
public class VaultService {

    private final VaultRepository vaultRepository;

    public VaultService(VaultRepository vaultRepository) {
        this.vaultRepository = vaultRepository;
    }
}
