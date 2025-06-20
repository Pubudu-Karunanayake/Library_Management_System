package com.example.library_management_project.dto.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateBookDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String isbn;

    @NotNull
    @Past
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate publishedDate;

    @Min(value = 1)
    private int numberOfCopies;

    @NotNull
    private Long authorId;

    @NotNull
    private Long categoryId;
}
