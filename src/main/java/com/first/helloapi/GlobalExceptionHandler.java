package com.first.helloapi;

import lombok.NonNull;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> validationExceptionHandler(@NonNull MethodArgumentNotValidException exception){
        String errorMessage = exception.getBindingResult()
                .getFieldErrors().stream().findFirst()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse("Validation failed!");
        return new ResponseEntity<>(new ErrorDTO(errorMessage), HttpStatus.BAD_REQUEST); /* 400 */
    }
}
