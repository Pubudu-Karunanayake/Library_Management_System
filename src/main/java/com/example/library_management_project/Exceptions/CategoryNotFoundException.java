package com.example.library_management_project.Exceptions;

public class CategoryNotFoundException extends ResourceNotFoundException{
    public CategoryNotFoundException() {
        super("Category Not Found....!");
    }
}
