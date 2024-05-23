package com.hyunwootem.hyunwootemproject.service;


import com.hyunwootem.hyunwootemproject.dto.request.ProductDetailRequestDto;
import com.hyunwootem.hyunwootemproject.entity.ProductCategory;
import com.hyunwootem.hyunwootemproject.entity.ProductDetail;
import com.hyunwootem.hyunwootemproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {


    private final ProductRepository productRepository;

    /**
     * 카테고리 생성
     * @param name
     * @param imageUrl
     * @return Long(id)
     */
    @Transactional
    public Long createProductCategory(String name, String imageUrl) {
        ProductCategory productCategory = ProductCategory.create(name, imageUrl);
        ProductCategory saveProduct = productRepository.save(productCategory);
        return saveProduct.getId();
    }


    /**
     * 카테고리 전체 읽기
     * @return
     */
    public List<ProductCategory> findAllProduct(){
        return productRepository.findAll();
    }

    /**
     * 카테고리 수정
     * @param id
     * @param name
     * @param imageUrl
     */
    @Transactional
    public void updateProductCategory(Long id,String name,String imageUrl){
        ProductCategory productCategory = productRepository.findById(id).orElseThrow();
        productCategory.setName(name);
        productCategory.setImage(imageUrl);
    }

    @Transactional
    public void deleteProductCategory(Long id) {
        productRepository.deleteById(id);
    }

}
