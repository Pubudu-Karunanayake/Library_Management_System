package com.example.library_management_project.Exceptions;

public class AuthorNotFoundException extends ResourceNotFoundException{
    public AuthorNotFoundException() {
        super("Author Not Found...!");
    }
}
