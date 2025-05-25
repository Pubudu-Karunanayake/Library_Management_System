package com.example.library_management_project.Service.Impl;

import com.example.library_management_project.DTO.Request.CreateBookRequestDTO;
import com.example.library_management_project.Exceptions.AuthorNotFoundException;
import com.example.library_management_project.Exceptions.CategoryNotFoundException;
import com.example.library_management_project.Model.Author;
import com.example.library_management_project.Model.Book;
import com.example.library_management_project.Model.Category;
import com.example.library_management_project.Repository.AuthorRepository;
import com.example.library_management_project.Repository.BookRepository;
import com.example.library_management_project.Repository.CategoryRepository;
import com.example.library_management_project.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private CategoryRepository categoryRepository;

    @Override
    public void addBook(CreateBookRequestDTO createBookRequestDTO) throws AuthorNotFoundException,CategoryNotFoundException{
            Book book = new Book();
            book.setTitle(createBookRequestDTO.getTitle());
            book.setIsbn(createBookRequestDTO.getIsbn());
            book.setPublishedDate(createBookRequestDTO.getPublishedDate());
            book.setTotalCopies(createBookRequestDTO.getNumberOfCopies());
            book.setAvailableCopies(createBookRequestDTO.getNumberOfCopies());

            Optional<Author> authorOptional = authorRepository.findById(createBookRequestDTO.getAuthorId());
            Optional<Category> categoryOptional = categoryRepository.findById(createBookRequestDTO.getCategoryId());

            if(!authorOptional.isPresent()){
                throw new AuthorNotFoundException();
            }
            else if(!categoryOptional.isPresent()){
                throw new CategoryNotFoundException();
            }
            else {
                book.setAuthor(authorOptional.get());
                book.setCategory(categoryOptional.get());
        }
            bookRepository.save(book);
    }
}

