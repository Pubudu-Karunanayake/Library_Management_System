package com.example.library_management_project.Controller;

import com.example.library_management_project.DTO.Request.CreateAuthorRequestDTO;
import com.example.library_management_project.Exceptions.AuthorNotFoundException;
import com.example.library_management_project.Repository.AuthorRepository;
import com.example.library_management_project.Service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AuthorController {
    private AuthorService authorService;

    @PostMapping(value = "/save-authors")
    public void createAuthor(@RequestBody CreateAuthorRequestDTO createAuthorRequestDTO){
        authorService.createAuthor(createAuthorRequestDTO);
    }

    @PutMapping(value = "/update-authors/{id}")
    public void updateAuthors(@PathVariable Long id,
                              @RequestBody CreateAuthorRequestDTO createAuthorRequestDTO)throws AuthorNotFoundException {
        authorService.updateAuthor(id, createAuthorRequestDTO);
    }
}
