package com.example.library_management_project.DTO.Response;

import lombok.Data;

@Data
public class ErrorResponseDTO {
    private String message;
    public ErrorResponseDTO(String message) {
        this.message = message;
    }
}
