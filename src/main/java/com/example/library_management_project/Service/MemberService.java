package com.example.library_management_project.Service;

import com.example.library_management_project.dto.member.CreateMemberDTO;
import com.example.library_management_project.Exceptions.MemberNotFoundException;

public interface MemberService {
    void createMember(CreateMemberDTO createMemberRequestDTO);
    void updateMember(Long id, CreateMemberDTO createMemberRequestDTO)throws MemberNotFoundException;
}
