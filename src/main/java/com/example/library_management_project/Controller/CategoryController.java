package com.example.library_management_project.Controller;

import com.example.library_management_project.DTO.Request.CreateCategoryRequestDTO;
import com.example.library_management_project.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @PostMapping(value ="/categories")
    public void createCategory(@RequestBody CreateCategoryRequestDTO createCategoryRequestDTO){
        categoryService.createCategory(createCategoryRequestDTO);
    }
}
