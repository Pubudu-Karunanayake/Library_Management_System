package com.example.library_management_project.Repository;

import com.example.library_management_project.Model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowBookRepository extends JpaRepository<BorrowBook, Long> {
}
