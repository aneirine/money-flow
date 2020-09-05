package com.aneirine.vaultservice.api.vaults;

import com.aneirine.vaultservice.api.vaults.domain.VaultData;
import com.aneirine.vaultservice.api.vaults.domain.VaultResponse;
import com.aneirine.vaultservice.entities.Vault;
import com.aneirine.vaultservice.entities.enums.VaultType;
import org.springframework.stereotype.Service;

@Service
public class VaultService {

    private final VaultRepository vaultRepository;

    public VaultService(VaultRepository vaultRepository) {
        this.vaultRepository = vaultRepository;
    }

    public VaultResponse createVault(VaultData data){
        VaultType type  = VaultType.getVaultTypeByOrdinal(data.getVaultTypeOrdinal());
        Vault vault = Vault.builder()
                .name(data.getName())
                .description(data.getDescription())
                .sum(data.getSum())
                .type(type)
                .build();
        vaultRepository.save(vault);
        return new VaultResponse(vault);
    }
}
