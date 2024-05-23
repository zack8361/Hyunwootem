package com.hyunwootem.hyunwootemproject.service;


import com.hyunwootem.hyunwootemproject.entity.Member;
import com.hyunwootem.hyunwootemproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    @Transactional
    public Long createAdmin(String email, String name, String password){
        Member member = new Member(email,name,password);
        memberRepository.save(member);
        return member.getId();
    }

}
