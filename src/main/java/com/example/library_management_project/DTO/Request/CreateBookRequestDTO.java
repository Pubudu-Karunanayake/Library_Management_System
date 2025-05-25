package com.example.library_management_project.DTO.Request;

import lombok.Data;

@Data
public class CreateBookRequestDTO {
    private String title;
    private String isbn;
    private String publishedDate;
    private int numberOfCopies;
    private Long authorId;
    private Long categoryId;
}
