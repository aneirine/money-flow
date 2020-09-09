package com.aneirine.userservice.api.users.domain;

import com.aneirine.userservice.entities.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserResponse {

    private long id;
    private String username;
    private String email;
    private List<Long> jarIdList;
    private List<Long> transactionIdList;
    private List<Long> vaultIdList;


    public UserResponse(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.jarIdList = new ArrayList<>(user.getJarIdList());
        this.transactionIdList = new ArrayList<>(user.getTransactionIdList());
        this.vaultIdList = new ArrayList<>(user.getVaultIdList());

    }

}
