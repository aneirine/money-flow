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

    public void removeVaultFromUserById(long vaultId) {
        User user = userRepository.findByVaults(vaultId);
        if (user == null) throw new NotFoundException("USER_NOT_FOUND");
        user.removeVault(vaultId);
        userRepository.save(user);
    }

    public void removeTransactionFromUserById(long transactionId){
        User user = userRepository.findByTransactions(transactionId);
        if (user == null) throw new NotFoundException("USER_NOT_FOUND");
        user.removeTransaction(transactionId);
        userRepository.save(user);

    }

    public void removeJarFromUserById(long jarId){
        User user = userRepository.findByJars(jarId);
        if (user == null) throw new NotFoundException("USER_NOT_FOUND");
        user.removeJar(jarId);
        userRepository.save(user);

    }

}
