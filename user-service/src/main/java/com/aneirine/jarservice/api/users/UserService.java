package com.aneirine.jarservice.api.users;

import com.aneirine.jarservice.api.feign.TransactionFeignService;
import com.aneirine.jarservice.api.users.domain.TransactionIdsList;
import com.aneirine.jarservice.api.users.domain.UserData;
import com.aneirine.jarservice.api.users.domain.UserResponse;
import com.aneirine.jarservice.entities.User;
import com.aneirine.jarservice.exceptions.ConflictException;
import com.aneirine.jarservice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionFeignService transactionFeignService;

    public UserResponse createUser(UserData data) {
        User user = new User();
        if (userRepository.existsByEmail(data.getEmail())) {
            throw new ConflictException("EMAIL_ALREADY_USED");
        }
        user.setEmail(data.getEmail());
        user.setUsername(data.getUsername());
        user.setTransactionIdList(new ArrayList<>());
        userRepository.save(user);
        return new UserResponse(user);
    }

    public UserResponse getUserById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
        return new UserResponse(user);
    }

    public UserResponse updateUserById(long id, UserData userData) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
        User emailUser = userRepository.findByEmail(userData.getEmail());
        if (emailUser != null && emailUser.getId() != id) {
            throw new ConflictException("EMAIL_ALREADY_USED");
        }
        user.setEmail(userData.getEmail());
        user.setUsername(userData.getUsername());
        userRepository.save(user);
        return new UserResponse(user);
    }

    public void deleteUserById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
        transactionFeignService.deleteAllTransactionsByIds(new TransactionIdsList(user.getTransactionIdList()));
        userRepository.delete(user);
    }

    public void addTransactionToUser(long userId, long transactionId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
        user.addTransaction(transactionId);
        userRepository.save(user);
    }


    public List<Long> getTransactionsIdByUserId(long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
        return user.getTransactionIdList();
    }


    public void addJarToUser(long userId, long jarId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
        user.addJar(jarId);
        userRepository.save(user);
    }
}
