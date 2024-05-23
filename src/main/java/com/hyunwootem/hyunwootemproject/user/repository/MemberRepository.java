package com.hyunwootem.hyunwootemproject.repository;

import com.hyunwootem.hyunwootemproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    
}
