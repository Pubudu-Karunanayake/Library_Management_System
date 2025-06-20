package com.example.library_management_project.Service.Impl;

import com.example.library_management_project.dto.author.AuthorResponseDTO;
import com.example.library_management_project.dto.author.CreateAuthorDTO;
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
    public AuthorResponseDTO createAuthor(CreateAuthorDTO createAuthorDTO) {
        Author author = new Author();
        author.setName(createAuthorDTO.getName());
        author.setBio(createAuthorDTO.getBio());
        author.setEmail(createAuthorDTO.getEmail());
        Author savedAuthor = authorRepository.save(author);
        return new AuthorResponseDTO(
                savedAuthor.getId(),
                savedAuthor.getName(),
                savedAuthor.getBio(),
                savedAuthor.getEmail()
        );
    }

    public void updateAuthor(Long id, CreateAuthorDTO createAuthorRequestDTO) throws AuthorNotFoundException {
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
