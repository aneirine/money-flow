package com.aneirine.userservice.api.users;

import com.aneirine.userservice.api.users.domain.IdListData;
import com.aneirine.userservice.api.feign.JarFeignService;
import com.aneirine.userservice.api.feign.TransactionFeignService;
import com.aneirine.userservice.api.users.domain.UserData;
import com.aneirine.userservice.api.users.domain.UserResponse;
import com.aneirine.userservice.exceptions.NotFoundException;
import com.aneirine.userservice.entities.User;
import com.aneirine.userservice.exceptions.ConflictException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TransactionFeignService transactionFeignService;
    private final JarFeignService jarFeignService;

    public UserService(UserRepository userRepository, TransactionFeignService transactionFeignService, JarFeignService jarFeignService) {
        this.userRepository = userRepository;
        this.transactionFeignService = transactionFeignService;
        this.jarFeignService = jarFeignService;
    }

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
        transactionFeignService.deleteAllTransactionsByIds(new IdListData(user.getTransactionIdList()));
        jarFeignService.deleteJarsByIds(new IdListData(user.getJarIdList()));

        userRepository.delete(user);
    }


}
