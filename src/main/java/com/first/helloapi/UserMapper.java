package com.first.helloapi;

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
