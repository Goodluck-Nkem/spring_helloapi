package com.first.helloapi;

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
    public ResponseEntity<UserCreateResponseDTO> create(@Valid @RequestBody UserCreateRequestDTO data) {
        UserEntity entity = userService.createUser(data);
        return new ResponseEntity<>(userMapper.toCreateResponseDTO(entity), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserFetchResponseDTO>> fetchAll() {
        List<UserEntity> users = userService.fetchAllUsers();
        List<UserFetchResponseDTO> fetchResponseDTOS = users.stream().map(userMapper::toFetchResponseDTO).toList();
        return ResponseEntity.ok(fetchResponseDTOS);
    }
}
