package com.aneirine.userservice.api.users;

import com.aneirine.userservice.entities.User;
import com.aneirine.userservice.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAdditionalService {

    private final UserRepository userRepository;

    public UserAdditionalService(UserRepository userRepository) {
        this.userRepository = userRepository;
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

    public void addVaultToUser(long userId, long vaultId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
        user.addVault(vaultId);
        userRepository.save(user);
    }

    public List<Long> getVaultsByUserId(long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
        return user.getVaultIdList();
    }

}
