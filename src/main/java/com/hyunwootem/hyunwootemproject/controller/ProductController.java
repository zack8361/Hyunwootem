package com.hyunwootem.hyunwootemproject.controller;


import com.hyunwootem.hyunwootemproject.dto.common.ProductCategoryDto;
import com.hyunwootem.hyunwootemproject.dto.request.ProductRequestDto;
import com.hyunwootem.hyunwootemproject.entity.ProductCategory;
import com.hyunwootem.hyunwootemproject.repository.ProductRepository;
import com.hyunwootem.hyunwootemproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    // 물품 category 추가. ex) 0001, 0002, 0003
    @PostMapping("/createProductCategory")
    public ResponseEntity<?> createProductCategory(@ModelAttribute("product") ProductRequestDto product) {

        Long productCategoryId = productService.createProductCategory(product.getName(), product.getImage());

        return ResponseEntity.ok(200);
    }

    // 물품 category 전체 조회
    @GetMapping("/getProductCategory")
    public List<ProductCategoryDto> getProductCategory() {

        return productRepository.findAll().stream()
                .map(ProductCategoryDto::new)
                .collect(Collectors.toList());
    }

    // 물품 category 수정
    @PutMapping("/updateProductCategory")
    public ResponseEntity<?> updateProductCategory(@ModelAttribute("product") ProductRequestDto product) {

        productService.updateProductCategory(product.getId(), product.getName(), product.getImage());

        return ResponseEntity.ok(200);
    }

    // 물품 category 삭제
    @DeleteMapping("/deleteProductCategory/{id}")
    public ResponseEntity<?> deleteProductCategory(@PathVariable("id") Long id){
        productService.deleteProductCategory(id);

        return ResponseEntity.ok(200);
    }
    
    
    // 물품 categoryDetail 추가
}
