package com.example.library_management_project.Service.Impl;

import com.example.library_management_project.DTO.Request.CreateCategoryRequestDTO;
import com.example.library_management_project.Model.Category;
import com.example.library_management_project.Repository.CategoryRepository;
import com.example.library_management_project.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public void createCategory(CreateCategoryRequestDTO createCategoryRequestDTO) {
        Category category = new Category();
        category.setName(createCategoryRequestDTO.getName());
        category.setDescription(createCategoryRequestDTO.getDescription());
        categoryRepository.save(category);
    }
}
