package com.example.library_management_project.Repository;

import com.example.library_management_project.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
