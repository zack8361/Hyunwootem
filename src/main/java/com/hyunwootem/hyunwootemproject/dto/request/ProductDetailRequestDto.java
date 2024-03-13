package com.hyunwootem.hyunwootemproject.dto.request;


import lombok.Data;

@Data
public class ProductDetailRequestDto {
    String name;
    String image;
    String content;
    int amount;
}
