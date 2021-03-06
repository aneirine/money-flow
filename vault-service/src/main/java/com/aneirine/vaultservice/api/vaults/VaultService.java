package com.aneirine.vaultservice.api.vaults;

import com.aneirine.vaultservice.api.feign.UserFeignService;
import com.aneirine.vaultservice.api.vaults.domain.VaultData;
import com.aneirine.vaultservice.api.vaults.domain.VaultResponse;
import com.aneirine.vaultservice.entities.Vault;
import com.aneirine.vaultservice.entities.enums.VaultType;
import com.aneirine.vaultservice.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VaultService {

    private final VaultRepository vaultRepository;
    private final UserFeignService userFeignService;

    public VaultService(VaultRepository vaultRepository, UserFeignService userFeignService) {
        this.vaultRepository = vaultRepository;
        this.userFeignService = userFeignService;
    }

    public VaultResponse createVault(VaultData data) {
        try {
            userFeignService.getUserById(data.getUserId());
        } catch (Exception e) {
            throw new NotFoundException("USER_NOT_FOUND");
        }

        VaultType type = VaultType.getVaultTypeByOrdinal(data.getVaultTypeOrdinal());
        Vault vault = Vault.builder()
                .name(data.getName())
                .description(data.getDescription())
                .sum(data.getSum())
                .type(type)
                .build();
        vaultRepository.save(vault);
        userFeignService.addVaultToUser(data.getUserId(), vault.getId());
        return new VaultResponse(vault);
    }

    public VaultResponse getVaultById(long id) {
        return new VaultResponse(
                vaultRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("VAULT_NOT_FOUND"))
        );
    }

    public List<VaultResponse> getVaultsByUserId(long userId) {
        List<Long> list = userFeignService.getVaultsByUserId(userId).getBody();
        List<Vault> vaults = vaultRepository.findAllByIdIn(list);
        List<VaultResponse> responses = vaults.stream()
                .map(VaultResponse::new)
                .collect(Collectors.toList());
        return responses;
    }

    public VaultResponse updateVaultResponseById(long id, VaultData data) {
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

    public void deleteVaultById(long id) {
        Vault vault = vaultRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("VAULT_NOT_FOUND"));
        userFeignService.removeVaultFromUserById(id);
        vaultRepository.deleteById(id);
    }

    public void deleteVaultsByIds(List<Long> list){
        vaultRepository.deleteAllByIdIn(list);
    }
}
