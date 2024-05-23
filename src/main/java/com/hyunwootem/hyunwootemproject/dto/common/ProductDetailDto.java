package com.hyunwootem.hyunwootemproject.dto.common;


import com.hyunwootem.hyunwootemproject.entity.ProductDetail;
import lombok.Data;

@Data
public class ProductDetailDto {

    private Long id;
    private String name;
    private String image;
    private String content;
    private int amount;
    public ProductDetailDto(ProductDetail productDetail) {
        id = productDetail.getId();
        name = productDetail.getName();
        image = productDetail.getImage();
        content = productDetail.getContent();
        amount = productDetail.getAmount();
    }
}
