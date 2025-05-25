package com.example.library_management_project.Service;

import com.example.library_management_project.DTO.Request.CreateBookRequestDTO;
import com.example.library_management_project.Exceptions.AuthorNotFoundException;
import com.example.library_management_project.Exceptions.CategoryNotFoundException;

public interface BookService {
    void addBook(CreateBookRequestDTO createBookRequestDTO) throws AuthorNotFoundException, CategoryNotFoundException;
}
