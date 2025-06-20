package com.example.library_management_project.Service.Impl;

import com.example.library_management_project.dto.member.CreateMemberDTO;
import com.example.library_management_project.Exceptions.MemberNotFoundException;
import com.example.library_management_project.Model.Member;
import com.example.library_management_project.Repository.MemberRepository;
import com.example.library_management_project.Service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;

    @Override
    public void createMember(CreateMemberDTO createMemberRequestDTO) {
        Member member = new Member();
        member.setName(createMemberRequestDTO.getName());
        member.setEmail(createMemberRequestDTO.getEmail());
        memberRepository.save(member);
    }

    @Override
    public void updateMember(Long id, CreateMemberDTO createMemberRequestDTO) throws MemberNotFoundException{
        Optional<Member> optionalMember = memberRepository.findById(id);
        if(optionalMember.isEmpty()){
            throw new MemberNotFoundException();
        }
        Member member = optionalMember.get();

        if(createMemberRequestDTO.getEmail() != null){
            member.setEmail(createMemberRequestDTO.getEmail());
        }
        memberRepository.save(member);
    }
}
