package com.first.helloapi.mapper;

import com.first.helloapi.dto.user.UserCreate_ResponseDTO;
import com.first.helloapi.dto.user.UserFetch_ResponseDTO;
import com.first.helloapi.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserFetch_ResponseDTO toFetchResponseDTO(UserEntity user){
        return new UserFetch_ResponseDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getDateCreated(),
                user.getDateUpdated()
        );
    }

    public UserCreate_ResponseDTO toCreateResponseDTO(UserEntity user){
        return new UserCreate_ResponseDTO(
                user.getId()
        );
    }
}
