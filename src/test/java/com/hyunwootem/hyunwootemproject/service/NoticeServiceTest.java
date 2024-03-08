package com.hyunwootem.hyunwootemproject.service;

import com.hyunwootem.hyunwootemproject.entity.Member;
import com.hyunwootem.hyunwootemproject.entity.Notice;
import com.hyunwootem.hyunwootemproject.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Rollback(false)
class NoticeServiceTest {

    @Autowired NoticeService noticeService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void noticeCreateTest() throws Exception {
        //given
        Member member = new Member("zack6353@naver.com","이찬호","paul2858");
        memberRepository.save(member);

        Long createNoticeId = noticeService.createNotice(member.getId(), "제목1", "내용1");
        //when
        assertThat(createNoticeId).isEqualTo(1L);
        //then

    }
}