package com.hyunwootem.hyunwootemproject.controller;


import com.hyunwootem.hyunwootemproject.dto.request.RegisterRequestDto;
import com.hyunwootem.hyunwootemproject.repository.MemberRepository;
import com.hyunwootem.hyunwootemproject.service.MemberService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ManagerController {


    private final MemberService memberService;

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterRequestDto registerRequestDto) {
        Long adminId = memberService.createAdmin(registerRequestDto.getEmail(), registerRequestDto.getName(), registerRequestDto.getPassword());
        System.out.println("adminId = " + adminId + "번쨰 회원가입 완료");

        return "index";
    }
}
