package com.example.library_management_project.Repository;

import com.example.library_management_project.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
