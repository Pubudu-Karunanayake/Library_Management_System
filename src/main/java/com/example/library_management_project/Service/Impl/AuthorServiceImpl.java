package com.example.library_management_project.Service.Impl;

import com.example.library_management_project.DTO.Request.CreateAuthorRequestDTO;
import com.example.library_management_project.DTO.Request.CreateBookRequestDTO;
import com.example.library_management_project.Exceptions.AuthorNotFoundException;
import com.example.library_management_project.Model.Author;
import com.example.library_management_project.Repository.AuthorRepository;
import com.example.library_management_project.Service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public void createAuthor(CreateAuthorRequestDTO createAuthorRequestDTO) {
        Author author = new Author();
        author.setName(createAuthorRequestDTO.getName());
        author.setBio(createAuthorRequestDTO.getBio());
        authorRepository.save(author);
    }

    public void updateAuthor(Long id, CreateAuthorRequestDTO createAuthorRequestDTO) throws AuthorNotFoundException {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isEmpty()) {
            throw new AuthorNotFoundException();
        }
        Author author = authorOptional.get();

        if(createAuthorRequestDTO.getBio() != null){
            author.setBio(createAuthorRequestDTO.getBio());
        }
        if (createAuthorRequestDTO.getName() != null) {
            author.setName(createAuthorRequestDTO.getName());
        }
            authorRepository.save(author);
    }
}
