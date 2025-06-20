package com.example.library_management_project.Service;

import com.example.library_management_project.dto.book.BookResponseDTO;
import com.example.library_management_project.dto.book.CreateBookDTO;
import com.example.library_management_project.Exceptions.AuthorNotFoundException;
import com.example.library_management_project.Exceptions.CategoryNotFoundException;

public interface BookService {
    BookResponseDTO addBook(CreateBookDTO createBookDTO) throws AuthorNotFoundException, CategoryNotFoundException;
}
