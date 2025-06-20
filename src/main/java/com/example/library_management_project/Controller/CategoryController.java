package com.example.library_management_project.Controller;

import com.example.library_management_project.dto.category.CategoryResponse;
import com.example.library_management_project.dto.category.CreateCategoryDTO;
import com.example.library_management_project.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @PostMapping("/categories")
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CreateCategoryDTO createCategoryDTO) {
        CategoryResponse categoryResponse = categoryService.createCategory(createCategoryDTO);

        URI location = URI.create("/api/categories/" + categoryResponse.getId());
        return ResponseEntity.
                created(location).
                body(categoryResponse);
    }

//    @PostMapping(value ="/categories")
//    public void createCategory(@RequestBody CreateCategoryDTO createCategoryRequestDTO){
//        categoryService.createCategory(createCategoryRequestDTO);
//    }
}
