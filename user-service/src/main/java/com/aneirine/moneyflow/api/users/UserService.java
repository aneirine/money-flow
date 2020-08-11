package com.aneirine.moneyflow.api.users;

import com.aneirine.moneyflow.api.users.domain.UserData;
import com.aneirine.moneyflow.entities.User;
import com.aneirine.moneyflow.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserData data) {
        User user = new User();
        user.setEmail(data.getEmail());
        user.setUsername(data.getUsername());
        userRepository.save(user);
        return user;
    }

    public void addTransactionToUser(long userId, long transactionId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
        user.addTransaction(transactionId);
        userRepository.save(user);
    }
}
