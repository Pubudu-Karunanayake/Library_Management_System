package com.example.library_management_project.Controller;

import com.example.library_management_project.dto.member.CreateMemberDTO;
import com.example.library_management_project.Exceptions.MemberNotFoundException;
import com.example.library_management_project.Service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @PostMapping(value = "/save-members")
    public void createMember (@RequestBody CreateMemberDTO createMemberRequestDTO){
        memberService.createMember(createMemberRequestDTO);
    }
    @PostMapping(value = "/update-members/{id}")
    public void updateMember(@PathVariable Long id,
                             @RequestBody CreateMemberDTO createMemberRequestDTO)throws MemberNotFoundException {
        memberService.updateMember(id,createMemberRequestDTO);
    }
}
