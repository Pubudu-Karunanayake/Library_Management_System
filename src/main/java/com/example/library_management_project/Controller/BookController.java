package com.example.library_management_project.Controller;

import com.example.library_management_project.dto.book.BookResponseDTO;
import com.example.library_management_project.dto.book.CreateBookDTO;
import com.example.library_management_project.Exceptions.AuthorNotFoundException;
import com.example.library_management_project.Exceptions.CategoryNotFoundException;
import com.example.library_management_project.Service.BookService;
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
public class BookController {
    private BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<BookResponseDTO> createBook(@Valid @RequestBody CreateBookDTO createBookDTO)
            throws CategoryNotFoundException, AuthorNotFoundException {
        BookResponseDTO savedBook = bookService.addBook(createBookDTO);
        URI location = URI.create("/api/books/" + savedBook.getId());
        return ResponseEntity
                .created(location)
                .body(savedBook);
    }

//    @PostMapping(value = "/save-books")
//    public void createBook (@RequestBody CreateBookDTO createBookRequestDTO)throws
//            AuthorNotFoundException, CategoryNotFoundException {
//        bookService.addBook(createBookRequestDTO);
//    }
}
