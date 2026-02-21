package com.first.helloapi.service;

import com.first.helloapi.dto.user.UserCreate_RequestDTO;
import com.first.helloapi.entity.UserEntity;
import com.first.helloapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity createUser(UserCreate_RequestDTO data) {
        Instant now = Instant.now();
        UserEntity user = new UserEntity(
                null,
                data.firstName(),
                data.lastName(),
                now,
                now
        );
        return userRepository.save(user);
    }

    public List<UserEntity> fetchAllUsers() {
        return userRepository.findAll();
    }
}
