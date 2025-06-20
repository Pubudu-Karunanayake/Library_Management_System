package com.example.library_management_project.dto.author;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorResponseDTO {
    private Long id;
    private String name;
    private String bio;
    private String email;
}
