package com.hyunwootem.hyunwootemproject.controller;


import com.hyunwootem.hyunwootemproject.dto.request.NoticeRequestDto;
import com.hyunwootem.hyunwootemproject.dto.response.NoticeResponseDto;
import com.hyunwootem.hyunwootemproject.entity.Member;
import com.hyunwootem.hyunwootemproject.entity.Notice;
import com.hyunwootem.hyunwootemproject.repository.MemberRepository;
import com.hyunwootem.hyunwootemproject.repository.NoticeRepository;
import com.hyunwootem.hyunwootemproject.service.MemberService;
import com.hyunwootem.hyunwootemproject.service.NoticeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor

public class NoticeController {

    private final MemberRepository memberRepository;
    private final NoticeRepository noticeRepository;

    private final MemberService memberService;
    private final NoticeService noticeService;

    @PostMapping("/createNotice")
    public String createNotice(@ModelAttribute("noticeRequest") @Valid NoticeRequestDto noticeRequest) {

        Long createNoticeId = noticeService.createNotice(noticeRequest.getMemberId(), noticeRequest.getTitle(), noticeRequest.getContent());
        System.out.println("createNoticeId = " + createNoticeId + "번째 공지사항 생성 완료");
        return "index";
    }

    
    // 공지사항 페이지 처리 localhost:8080/findNotice?page=0 부터 날리면됨
    @GetMapping("/findNotice")
    public String findAllNotice(@PageableDefault(size = 15) Pageable pageable){
        Page<Notice> page = noticeRepository.findAll(pageable);
        Page<NoticeResponseDto> map = page.map(NoticeResponseDto::new);

        for (NoticeResponseDto noticeResponseDto : map) {
            System.out.println("noticeResponseDto = " + noticeResponseDto);
        }

        return "index";
    }
    
    // 공지 수정
    @PutMapping("/updateNotice/{id}")
    public String updateNotice(@PathVariable("id") Long id,@ModelAttribute("noticeRequest") NoticeRequestDto noticeRequest) {
        noticeService.updateNotice(id,noticeRequest.getTitle(),noticeRequest.getContent());
        return "index";
    }
}