package com.example.library_management_project.Repository;

import com.example.library_management_project.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
