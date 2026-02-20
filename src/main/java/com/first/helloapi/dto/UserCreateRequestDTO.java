package com.first.helloapi.dto;

import jakarta.validation.constraints.NotBlank;

/* This is what should be the body of user's post request */
public record UserCreateRequestDTO(
        @NotBlank(message = ERROR_MESSAGE_BLANK)
        String firstName,

        @NotBlank(message = ERROR_MESSAGE_BLANK)
        String lastName) {
    private static final String ERROR_MESSAGE_BLANK = "Name must not be blank!";
}
