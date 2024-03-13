package com.hyunwootem.hyunwootemproject.service;

import com.hyunwootem.hyunwootemproject.dto.request.ProductDetailRequestDto;
import com.hyunwootem.hyunwootemproject.entity.ProductCategory;
import com.hyunwootem.hyunwootemproject.entity.ProductDetail;
import com.hyunwootem.hyunwootemproject.repository.ProductDetailRepository;
import com.hyunwootem.hyunwootemproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductDetailService {

    private final ProductDetailRepository productDetailRepository;
    private final ProductRepository productRepository;

    public Long createProductDetail(Long id, String name,String image,String content,int amount){
        ProductCategory productCategory = productRepository.findById(id).orElseThrow();
        ProductDetail createProduct = ProductDetail.create(productCategory,name,image,content,amount);
        ProductDetail saveProduct = productDetailRepository.save(createProduct);
        return saveProduct.getId();
    }

}
