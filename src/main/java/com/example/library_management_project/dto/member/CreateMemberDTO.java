package com.example.library_management_project.dto.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateMemberDTO {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Pattern(regexp = "0\\d{9}", message = "Phone number must be 10 digits starting with 0")
    private String phone;
    @NotBlank
    private String address;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthday;
}
