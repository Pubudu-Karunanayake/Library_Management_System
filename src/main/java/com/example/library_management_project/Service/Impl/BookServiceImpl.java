package com.example.library_management_project.Service.Impl;

import com.example.library_management_project.dto.book.BookResponseDTO;
import com.example.library_management_project.dto.book.CreateBookDTO;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private CategoryRepository categoryRepository;

    @Override
    @Transactional (rollbackFor = {AuthorNotFoundException.class, CategoryNotFoundException.class})
    public BookResponseDTO addBook(CreateBookDTO createBookDTO) throws AuthorNotFoundException,CategoryNotFoundException {
        Optional<Book> optionalBook = bookRepository.findByTitle(createBookDTO.getTitle());
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTotalCopies(book.getTotalCopies() + createBookDTO.getNumberOfCopies());
            book.setAvailableCopies(book.getAvailableCopies() + createBookDTO.getNumberOfCopies());
            Book savedBook = bookRepository.save(book);

            return new BookResponseDTO(
                    savedBook.getId(),
                    savedBook.getTitle(),
                    savedBook.getIsbn(),
                    savedBook.getPublishedDate(),
                    savedBook.getTotalCopies(),
                    savedBook.getAuthor().getName(),
                    savedBook.getCategory().getName()
            );

        }

        Author author = authorRepository.findById(createBookDTO.getAuthorId()).orElseThrow(AuthorNotFoundException::new);
        Category category = categoryRepository.findById(createBookDTO.getCategoryId()).orElseThrow(CategoryNotFoundException::new);

            Book book = new Book();
            book.setTitle(createBookDTO.getTitle());
            book.setIsbn(createBookDTO.getIsbn());
            book.setPublishedDate(createBookDTO.getPublishedDate());
            book.setTotalCopies(createBookDTO.getNumberOfCopies());
            book.setAvailableCopies(createBookDTO.getNumberOfCopies());
            book.setAuthor(author);
            book.setCategory(category);

            Book savedBook = bookRepository.save(book);
            return new BookResponseDTO(
                    savedBook.getId(),
                    savedBook.getTitle(),
                    savedBook.getIsbn(),
                    savedBook.getPublishedDate(),
                    savedBook.getTotalCopies(),
                    savedBook.getAuthor().getName(),
                    savedBook.getCategory().getName()
            );
        }
}


