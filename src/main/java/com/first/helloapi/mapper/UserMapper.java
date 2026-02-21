package com.first.helloapi.mapper;

import com.first.helloapi.dto.UserCreateResponseDTO;
import com.first.helloapi.dto.UserFetchResponseDTO;
import com.first.helloapi.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserFetchResponseDTO toFetchResponseDTO(UserEntity user){
        return new UserFetchResponseDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getDateCreated(),
                user.getDateUpdated()
        );
    }

    public UserCreateResponseDTO toCreateResponseDTO(UserEntity user){
        return new UserCreateResponseDTO(
                user.getId()
        );
    }
}
