package com.example.library_management_project.Repository;

import com.example.library_management_project.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
