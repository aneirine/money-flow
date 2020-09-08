package com.aneirine.vaultservice.api.vaults;

import com.aneirine.vaultservice.api.vaults.domain.VaultData;
import com.aneirine.vaultservice.api.vaults.domain.VaultResponse;
import com.aneirine.vaultservice.entities.Vault;
import com.aneirine.vaultservice.entities.enums.VaultType;
import com.aneirine.vaultservice.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaultService {

    private final VaultRepository vaultRepository;

    public VaultService(VaultRepository vaultRepository) {
        this.vaultRepository = vaultRepository;
    }

    public VaultResponse createVault(VaultData data) {
        VaultType type = VaultType.getVaultTypeByOrdinal(data.getVaultTypeOrdinal());
        Vault vault = Vault.builder()
                .name(data.getName())
                .description(data.getDescription())
                .sum(data.getSum())
                .type(type)
                .build();
        vaultRepository.save(vault);
        return new VaultResponse(vault);
    }

    public VaultResponse getVaultById(long id) {
        return new VaultResponse(
                vaultRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("VAULT_NOT_FOUND"))
        );
    }

    public List<VaultResponse> getVaultsByUserId(long userId){
        //soon, after  feign implementation
        return new ArrayList<>();
    }

    public VaultResponse updateVaultResponseById(long id, VaultData data){
        VaultType type = VaultType.getVaultTypeByOrdinal(data.getVaultTypeOrdinal());
        Vault vault = vaultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("VAULT_NOT_FOUND"));
        vault.setDescription(data.getDescription());
        vault.setName(data.getName());
        vault.setSum(data.getSum());
        vault.setType(type);
        vaultRepository.save(vault);
        return new VaultResponse(vault);
    }
}
