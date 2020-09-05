package com.aneirine.vaultservice.api.vaults.domain;

import com.aneirine.vaultservice.entities.Vault;
import com.aneirine.vaultservice.entities.enums.VaultType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VaultResponse {

    private long id;
    private String name;
    private double sum;
    private String description;
    private VaultType type;

    public VaultResponse(Vault vault) {
        this.id = vault.getId();
        this.name = vault.getName();
        this.sum = vault.getSum();
        this.description = vault.getDescription();
        this.type = vault.getType();
    }
}
