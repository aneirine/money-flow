package com.aneirine.jarservice.api.users.domain;

import com.aneirine.jarservice.entities.User;
import lombok.Data;

@Data
public class UserResponse {

    private long id;
    private String username;
    private String email;

    public UserResponse(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }

}