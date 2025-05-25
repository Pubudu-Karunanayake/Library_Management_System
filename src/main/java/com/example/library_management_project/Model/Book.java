package com.example.library_management_project.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.apache.catalina.User;

import java.util.List;

@Entity
@Data
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    private String title;
    private String isbn;
    private String publishedDate;

    @Min(value = 0)
    private Integer totalCopies = 0;
    @Min(value = 0)
    private Integer availableCopies = 0;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "book")
    private List<BorrowBook> borrowedBooks;
}
