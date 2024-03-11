package com.hyunwootem.hyunwootemproject.dto.response;


import com.hyunwootem.hyunwootemproject.entity.Member;
import com.hyunwootem.hyunwootemproject.entity.Notice;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoticeResponseDto {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private Member member;
    public NoticeResponseDto(Notice notice) {
        this.id = notice.getId();
        this.title = notice.getTitle();
        this.content = notice.getContent();
        this.createdDate = notice.getCreatedDate();
        this.lastModifiedDate = notice.getLastModifiedDate();
        this.member = notice.getMember();
    }
}
