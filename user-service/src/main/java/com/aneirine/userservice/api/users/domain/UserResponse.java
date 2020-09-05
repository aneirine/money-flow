package com.aneirine.userservice.api.users.domain;

import com.aneirine.userservice.entities.User;
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