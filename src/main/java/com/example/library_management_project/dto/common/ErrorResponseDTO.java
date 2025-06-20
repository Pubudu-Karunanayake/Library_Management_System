package com.example.library_management_project.dto.common;

import lombok.Data;

@Data
public class ErrorResponseDTO {
    private String message;
    public ErrorResponseDTO(String message) {
        this.message = message;
    }
}
