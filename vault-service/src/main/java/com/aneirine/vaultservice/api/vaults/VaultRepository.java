package com.aneirine.vaultservice.api.vaults;

import com.aneirine.vaultservice.entities.Vault;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaultRepository extends JpaRepository<Vault, Long> {

    List<Vault> findAllByIdIn(List<Long> list);

    void deleteAllByIdIn(List<Long> list);
}
