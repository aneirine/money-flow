package com.aneirine.moneyflow.api.users;

import com.aneirine.moneyflow.api.users.domain.UserData;
import com.aneirine.moneyflow.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User cratePerson(UserData data) {
        User user = new User();
        user.setEmail(data.getEmail());
        user.setUsername(data.getUsername());
        userRepository.save(user);
        return user;
    }
}
