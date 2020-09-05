package com.aneirine.vaultservice.entities.enums;

import com.aneirine.vaultservice.exceptions.NotFoundException;

public enum VaultType {
    CASH, CARD, ELECTRONIC, OTHER;

    public VaultType getVaultTypeByOrdinal(int ordinal) {
        for(VaultType temp : VaultType.values()){
            if(temp.ordinal() == ordinal){
                return temp;
            }
        }
        throw new NotFoundException("VAULT_TYPE_NOT_FOUND");
    }
}
