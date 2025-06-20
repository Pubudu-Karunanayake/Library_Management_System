package com.example.library_management_project.dto.author;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateAuthorDTO {

    @NotBlank(message = "You can't add an author without name..!")
    private String name;

    @NotNull(message = "Add a bio..!")
    private String bio;

    @NotBlank(message = "Email is required..!")
    @Email(message = "Invalid email..!")
    private String email;
}
