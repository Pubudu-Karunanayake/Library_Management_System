package com.example.library_management_project.Service.Impl;

import com.example.library_management_project.dto.category.CategoryResponse;
import com.example.library_management_project.dto.category.CreateCategoryDTO;
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
    public CategoryResponse createCategory(CreateCategoryDTO createCategoryDTO) {
        Category category = new Category();
        category.setName(createCategoryDTO.getName());
        category.setDescription(createCategoryDTO.getDescription());
        Category savedCategory = categoryRepository.save(category);

        return new CategoryResponse(
                savedCategory.getId(),
                savedCategory.getName(),
                savedCategory.getDescription()
        );
    }
}
