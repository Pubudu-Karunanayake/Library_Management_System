package com.example.library_management_project.Service;

import com.example.library_management_project.dto.category.CategoryResponse;
import com.example.library_management_project.dto.category.CreateCategoryDTO;

public interface CategoryService {
    CategoryResponse createCategory(CreateCategoryDTO createCategoryRequestDTO);
}
