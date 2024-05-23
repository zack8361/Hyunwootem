package com.hyunwootem.hyunwootemproject.service;


import com.hyunwootem.hyunwootemproject.dto.response.NoticeResponseDto;
import com.hyunwootem.hyunwootemproject.entity.Member;
import com.hyunwootem.hyunwootemproject.entity.Notice;
import com.hyunwootem.hyunwootemproject.repository.MemberRepository;
import com.hyunwootem.hyunwootemproject.repository.NoticeRepository;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final MemberRepository memberRepository;

    /**
     * 공지사항 생성
     * @param memberId
     * @param title
     * @param content
     * @return Notice.getId
     */
    @Transactional
    public Long createNotice(Long memberId, String title, String content){
        Member member = memberRepository.findById(memberId).orElseThrow();
        Notice notice = Notice.createNotice(title, content, member);
        
        Notice saveNotice = noticeRepository.save(notice);
        return saveNotice.getId();
    }


    /**
     * 공지사항 수정
     *
     * @param id
     * @param title
     * @param content
     */
    @Transactional
    public void updateNotice(Long id, @NotEmpty(message = "제목은 필수 사항 입니다.") String title, @NotEmpty(message = "내용은 필수 사항 입니다.") String content) {
        Notice notice = noticeRepository.findById(id).orElseThrow();
        notice.setTitle(title);
        notice.setContent(content);
    }

    /**
     * 공지사항 삭제
     * @param id
     */
    @Transactional
    public void deleteNoticeById(Long id) {
        noticeRepository.deleteById(id);
    }

    /**
     * 공지사항 단건 조회
     *
     * @param id
     * @return
     */
    public Notice findNoticeDetail(Long id) {
        return noticeRepository.findById(id).orElseThrow();
    }
}
