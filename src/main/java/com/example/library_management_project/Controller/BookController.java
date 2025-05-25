package com.example.library_management_project.Controller;

import com.example.library_management_project.DTO.Request.CreateBookRequestDTO;
import com.example.library_management_project.Exceptions.AuthorNotFoundException;
import com.example.library_management_project.Exceptions.CategoryNotFoundException;
import com.example.library_management_project.Exceptions.ResourceNotFoundException;
import com.example.library_management_project.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BookController {
    private BookService bookService;
    @PostMapping(value = "/save-books")
    public void createBook (@RequestBody CreateBookRequestDTO createBookRequestDTO)throws
            AuthorNotFoundException, CategoryNotFoundException {
        bookService.addBook(createBookRequestDTO);
    }
}
