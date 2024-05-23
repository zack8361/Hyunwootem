package com.hyunwootem.hyunwootemproject.controller;


import com.hyunwootem.hyunwootemproject.dto.common.ProductCategoryDto;
import com.hyunwootem.hyunwootemproject.dto.common.ProductDetailDto;
import com.hyunwootem.hyunwootemproject.dto.request.ProductDetailRequestDto;
import com.hyunwootem.hyunwootemproject.dto.request.ProductRequestDto;
import com.hyunwootem.hyunwootemproject.entity.ProductCategory;
import com.hyunwootem.hyunwootemproject.entity.ProductDetail;
import com.hyunwootem.hyunwootemproject.repository.ProductDetailRepository;
import com.hyunwootem.hyunwootemproject.repository.ProductRepository;
import com.hyunwootem.hyunwootemproject.service.ProductDetailService;
import com.hyunwootem.hyunwootemproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductService productService;
    private final ProductDetailService productDetailService;

    private final ProductRepository productRepository;
    private final ProductDetailRepository productDetailRepository;

    // 물품 category 추가. ex) 0001, 0002, 0003
    @PostMapping("/createProductCategory")
    public ResponseEntity<?> createProductCategory(@ModelAttribute("product") ProductRequestDto product) {

        Long productCategoryId = productService.createProductCategory(product.getName(), product.getImage());

        return ResponseEntity.ok(200);
    }

    // 물품 category 전체 조회
    @GetMapping("/getAllProductCategory")
    public List<ProductCategoryDto> getAllProductCategory() {

        return productRepository.findAll().stream()
                .map(ProductCategoryDto::new)
                .collect(Collectors.toList());
    }

    // 물품 category 단건 조회
    @GetMapping("/getProductCategory/{id}")
    public ProductCategoryDto getProductCategory(@PathVariable("id") Long id) {

        ProductCategory productCategory = productRepository.findById(id).orElseThrow();

        return new ProductCategoryDto(productCategory);
    }

    // category 수정
    @PutMapping("/updateProductCategory")
    public ResponseEntity<?> updateProductCategory(@ModelAttribute("product") ProductRequestDto product) {

        productService.updateProductCategory(product.getId(), product.getName(), product.getImage());

        return ResponseEntity.ok(200);
    }

    // category 삭제
    @DeleteMapping("/deleteProductCategory/{id}")
    public ResponseEntity<?> deleteProductCategory(@PathVariable("id") Long id){
        productService.deleteProductCategory(id);

        return ResponseEntity.ok(200);
    }
    

    // categoryDetail 추가
    @PostMapping("/createProductDetail/{id}")
    public ResponseEntity<?> createProductDetail(
            @PathVariable("id")Long id,
            @RequestBody ProductDetailRequestDto request){

        Long createProductDetailId = productDetailService.createProductDetail(id, request.getName(),request.getImage(),request.getContent(),request.getAmount());
        System.out.println("createProductDetailId = " + createProductDetailId + "번째 생성");
        return ResponseEntity.ok(200);
    }
    
    // CategoryDetail 페이징 조회
    @GetMapping("/getAllProductDetail")
    public Page<ProductDetailDto> getAllProductDetail(@PageableDefault(size = 5) Pageable pageable){

        return productDetailRepository.findAll(pageable).map(ProductDetailDto::new);
    }
    
    // CategoryDetail 단건 조회
    @GetMapping("/getProductDetail/{id}")
    public ProductDetailDto getProductDetail(@PathVariable("id") Long id){

        ProductDetail productDetail = productDetailRepository.findById(id).orElseThrow();

        return new ProductDetailDto(productDetail);
    }


    //CategoryDetail 수정
    @PutMapping("/updateProductDetail/{id}")
    public ResponseEntity<?> updateProductDetail(@PathVariable("id") Long id,
                                                 @RequestBody ProductDetailRequestDto request){

        productDetailService.updateProductDetail(id,request.getName(),request.getImage(),request.getContent(),request.getAmount());

        return ResponseEntity.ok(200);
    }
    
    
    // CategoryDetail 삭제
    @DeleteMapping("/deleteProductDetail/{id}")
    public ResponseEntity<?> deleteProductDetail(@PathVariable("id") Long id){

        productDetailRepository.deleteById(id);

        return ResponseEntity.ok(200);
    }
}



























