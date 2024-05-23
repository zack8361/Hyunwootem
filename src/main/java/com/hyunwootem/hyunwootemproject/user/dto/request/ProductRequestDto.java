package com.hyunwootem.hyunwootemproject.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class ProductRequestDto {

    private Long id;
    private String name;
    private String image;
}
