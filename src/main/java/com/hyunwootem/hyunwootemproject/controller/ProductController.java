package com.hyunwootem.hyunwootemproject.controller;


import com.hyunwootem.hyunwootemproject.dto.request.ProductRequestDto;
import com.hyunwootem.hyunwootemproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    // 물품 카테고리 추가. ex) 0001, 0002, 0003
    @PostMapping("/createProductCategory")
    public ResponseEntity<?> createProductCategory(@ModelAttribute("product") ProductRequestDto product){
        productService.createProductCategory(product.getName(),product.getImageUrl());
        return ResponseEntity.ok(200);
    }
}
