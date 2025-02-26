package com.bancopichincha.credito.automotriz.exception;

import com.bancopichincha.credito.automotriz.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDTO handlerGeneralException(RuntimeException e) {
        return ErrorResponseDTO.builder()
                .message(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponseDTO handlerNotFoundException(NotFoundException e) {
        return ErrorResponseDTO.builder()
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ErrorResponseDTO handlerAlreadyExistException(AlreadyExistException e) {
        return ErrorResponseDTO.builder()
                .message(e.getMessage())
                .status(HttpStatus.CONFLICT.value())
                .build();
    }

    @ExceptionHandler(CustomException.class)
    public ErrorResponseDTO handleCustomException(CustomException e) {
        return ErrorResponseDTO.builder()
                .message(e.getMessage())
                .status(e.getStatus().value())
                .build();
    }
}
