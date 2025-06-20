package com.example.library_management_project.dto.category;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCategoryDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
