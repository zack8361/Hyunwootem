package com.hyunwootem.hyunwootemproject.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class ProductRequestDto {
    @NotEmpty(message = "이름은 비어있을수 없습니다")
    private String name;
    @NotEmpty(message = "image는 비어 있을수 없습니다")
    private String imageUrl;
}
