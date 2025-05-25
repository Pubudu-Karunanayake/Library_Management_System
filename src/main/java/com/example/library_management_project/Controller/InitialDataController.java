package com.example.library_management_project.Controller;

import com.example.library_management_project.Model.*;
import com.example.library_management_project.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class InitialDataController {

    private AuthorRepository authorRepository;
    private CategoryRepository categoryRepository;
    private MemberRepository memberRepository;
    private BookRepository bookRepository;
    private BorrowBookRepository borrowBookRepository;

    @PostMapping(value = "/initialize")
    public void initializeData() {

        for (int m = 1; m <= 5; m++) {
            Author author1 = new Author();
            author1.setName("author " + m);
            author1.setBio("Bio " + m);
            authorRepository.save(author1);

            Member member1 = new Member();
            member1.setName("Member " + m);
            member1.setEmail("member" + m + "@gmail.com");
            memberRepository.save(member1);

            Category category1 = new Category();
            category1.setName("Category " + m);
            category1.setDescription("Description " + m);
            categoryRepository.save(category1);

            List<Book> bookList = new ArrayList<>();
            for (int b = 1; b <= 10; b++) {
                Book book1 = new Book();
                book1.setTitle(author1.getName() + "- Book " + b);
                book1.setIsbn("isbn" + b);
                book1.setPublishedDate(b +"/03/2025");
                book1.setTotalCopies(b);
                book1.setAvailableCopies(b);
                book1.setAuthor(author1);
                book1.setCategory(category1);
                bookRepository.save(book1);
                bookList.add(book1);
            }

            for (Book book : bookList) {
                BorrowBook borrowBook1 = new BorrowBook();
                borrowBook1.setMember(member1);
                borrowBook1.setBook(book);
                borrowBook1.setStatus("Status");
                borrowBookRepository.save(borrowBook1);
            }
        }
    }
}
