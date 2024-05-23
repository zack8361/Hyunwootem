package com.hyunwootem.hyunwootemproject.dto.request;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class NoticeRequestDto {

    private Long memberId;

    @NotEmpty(message = "제목은 필수 사항 입니다.")
    private String title;
    @NotEmpty(message = "내용은 필수 사항 입니다.")
    private String content;
}
