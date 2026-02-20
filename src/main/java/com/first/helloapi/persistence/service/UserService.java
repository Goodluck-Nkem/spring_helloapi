package com.first.helloapi.persistence.service;

import com.first.helloapi.dto.UserCreateRequestDTO;
import com.first.helloapi.domain.UserEntity;
import com.first.helloapi.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

/* User persistence layer service */
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity createUser(UserCreateRequestDTO data) {
        Instant now = Instant.now();
        UserEntity user = new UserEntity(
                null,
                data.firstName().trim(),
                data.lastName().trim(),
                now,
                now
        );
        return userRepository.save(user);
    }

    public List<UserEntity> fetchAllUsers() {
        return userRepository.findAll();
    }
}
