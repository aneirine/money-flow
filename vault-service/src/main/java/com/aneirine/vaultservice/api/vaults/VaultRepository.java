package com.aneirine.vaultservice.api.vaults;

import com.aneirine.vaultservice.entities.Vault;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaultRepository extends JpaRepository<Vault, Long> {
}
