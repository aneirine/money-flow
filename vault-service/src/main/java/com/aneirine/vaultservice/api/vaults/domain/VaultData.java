package com.aneirine.vaultservice.api.vaults.domain;

import lombok.Getter;

@Getter
public class VaultData {

    private String name;
    private double sum;
    private String description;
    private int vaultTypeOrdinal;
    private long userId;
}
