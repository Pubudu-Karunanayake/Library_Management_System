package com.example.library_management_project.Service;

import com.example.library_management_project.DTO.Request.CreateAuthorRequestDTO;
import com.example.library_management_project.Exceptions.AuthorNotFoundException;
import com.example.library_management_project.Model.Author;

public interface AuthorService {
    void createAuthor(CreateAuthorRequestDTO createAuthorRequestDTO);
    void updateAuthor(Long id,CreateAuthorRequestDTO createAuthorRequestDTO) throws AuthorNotFoundException;
}
