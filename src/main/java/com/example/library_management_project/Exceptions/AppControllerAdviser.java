package com.example.library_management_project.Exceptions;

import com.example.library_management_project.dto.common.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppControllerAdviser {
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({ResourceNotFoundException.class})
    public ErrorResponseDTO handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ErrorResponseDTO(ex.getMessage());
    }
}
