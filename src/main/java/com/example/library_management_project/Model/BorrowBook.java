package com.example.library_management_project.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Borrow_Books")
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowing_id")
    private Long id;

    private String status;
    @JoinColumn(name = "book_id")
    @ManyToOne
    private Book book;

    @JoinColumn(name = "member_id")
    @ManyToOne
    private Member member;
}
