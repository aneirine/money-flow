package com.aneirine.moneyflow.api.users.domain;

import lombok.Data;

@Data
public class UserResponse {

    private long id;
    private String username;
    private String email;

}
