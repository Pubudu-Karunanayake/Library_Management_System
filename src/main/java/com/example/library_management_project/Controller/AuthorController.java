package com.example.library_management_project.Controller;

import com.example.library_management_project.Model.Author;
import com.example.library_management_project.dto.author.AuthorResponseDTO;
import com.example.library_management_project.dto.author.CreateAuthorDTO;
import com.example.library_management_project.Exceptions.AuthorNotFoundException;
import com.example.library_management_project.Service.AuthorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AuthorController {
    private AuthorService authorService;

    @PostMapping("/authors")
    public ResponseEntity<AuthorResponseDTO> createAuthor(@Valid @RequestBody CreateAuthorDTO createAuthorDTO) {
        AuthorResponseDTO savedAuthor = authorService.createAuthor(createAuthorDTO);
        URI location = URI.create("/api/authors/" + savedAuthor.getId());
        return ResponseEntity
                .created(location)
                .body(savedAuthor);
    }

    @PutMapping(value = "/update-authors/{id}")
    public void updateAuthors(@PathVariable Long id,
                              @RequestBody CreateAuthorDTO createAuthorRequestDTO)throws AuthorNotFoundException {
        authorService.updateAuthor(id, createAuthorRequestDTO);
    }
}
