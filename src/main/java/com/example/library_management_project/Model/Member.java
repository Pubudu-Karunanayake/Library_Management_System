package com.example.library_management_project.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "Members")
@Data

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private LocalDate birthday;

    @OneToMany(mappedBy = "member")
    private List<BorrowBook> borrowedBooks;

}
