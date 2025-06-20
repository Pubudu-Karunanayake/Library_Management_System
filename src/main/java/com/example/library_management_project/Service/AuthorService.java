package com.example.library_management_project.Service;

import com.example.library_management_project.Model.Author;
import com.example.library_management_project.dto.author.AuthorResponseDTO;
import com.example.library_management_project.dto.author.CreateAuthorDTO;
import com.example.library_management_project.Exceptions.AuthorNotFoundException;

public interface AuthorService {
    AuthorResponseDTO createAuthor(CreateAuthorDTO createAuthorDTO);
    void updateAuthor(Long id, CreateAuthorDTO createAuthorRequestDTO) throws AuthorNotFoundException;
}
