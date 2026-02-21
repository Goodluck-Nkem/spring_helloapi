package com.first.helloapi.dto.user;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/* This is what should be the body of user's post request */
public record UserCreate_RequestDTO(
        @NotBlank(message = ERROR_MESSAGE_BLANK)
        @Length(min = 2, max = 255, message = ERROR_MESSAGE_LENGTH)
        String firstName,

        @NotBlank(message = ERROR_MESSAGE_BLANK)
        @Length(min = 2, max = 255, message = ERROR_MESSAGE_LENGTH)
        String lastName) {
    private static final String ERROR_MESSAGE_BLANK = "Name must not be blank!";
    private static final String ERROR_MESSAGE_LENGTH = "Name length must be between 2 and 255 inclusive";
}
