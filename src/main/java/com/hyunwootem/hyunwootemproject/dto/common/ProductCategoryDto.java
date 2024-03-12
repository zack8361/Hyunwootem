package com.hyunwootem.hyunwootemproject.dto.common;


import com.hyunwootem.hyunwootemproject.entity.ProductCategory;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProductCategoryDto {
    private Long id;
    private String name;
    private String image;
    private List<ProductDetailDto> productDetailDtoList;
    public ProductCategoryDto(ProductCategory productCategory) {
        id = productCategory.getId();
        name = productCategory.getName();
        image = productCategory.getImage();
        productDetailDtoList = productCategory.getProductDetailList().stream()
                .map(ProductDetailDto::new).collect(Collectors.toList());
    }
}
