package com.first.helloapi.controller;

import com.first.helloapi.entity.UserEntity;
import com.first.helloapi.dto.user.UserCreate_RequestDTO;
import com.first.helloapi.dto.user.UserCreate_ResponseDTO;
import com.first.helloapi.dto.user.UserFetch_ResponseDTO;
import com.first.helloapi.mapper.UserMapper;
import com.first.helloapi.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserCreate_ResponseDTO> create(@Valid @RequestBody UserCreate_RequestDTO data) {
        UserEntity entity = userService.createUser(data);
        return new ResponseEntity<>(userMapper.toCreateResponseDTO(entity), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserFetch_ResponseDTO>> fetchAll() {
        List<UserEntity> users = userService.fetchAllUsers();
        List<UserFetch_ResponseDTO> fetchResponseDTOS = users.stream().map(userMapper::toFetchResponseDTO).toList();
        return ResponseEntity.ok(fetchResponseDTOS);
    }
}
