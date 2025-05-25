package com.example.library_management_project.Exceptions;

public class MemberNotFoundException extends ResourceNotFoundException{
    public MemberNotFoundException() {
        super("Member Not Found");
    }
}
