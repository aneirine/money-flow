package com.aneirine.vaultservice.entities.enums;

public enum VaultType {
    CASH, CARD, ELECTRONIC, OTHER;

    public VaultType getVaultTypeByOrdinal(int ordinal) {
        for(VaultType temp : VaultType.values()){
            if(temp.ordinal() == ordinal){
                return temp;
            }
        }
        throw new NotFou
    }
}
