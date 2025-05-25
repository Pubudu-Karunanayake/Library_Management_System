package com.example.library_management_project.Service;

import com.example.library_management_project.DTO.Request.CreateMemberRequestDTO;
import com.example.library_management_project.Exceptions.MemberNotFoundException;
import com.example.library_management_project.Model.Member;

public interface MemberService {
    void createMember(CreateMemberRequestDTO createMemberRequestDTO);
    void updateMember(Long id,CreateMemberRequestDTO createMemberRequestDTO)throws MemberNotFoundException;
}
