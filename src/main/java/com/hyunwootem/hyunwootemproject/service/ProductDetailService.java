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

    /**
     * 생성
     * @param id
     * @param name
     * @param image
     * @param content
     * @param amount
     * @return createId
     */
    @Transactional
    public Long createProductDetail(Long id, String name,String image,String content,int amount){
        ProductCategory productCategory = productRepository.findById(id).orElseThrow();
        ProductDetail createProduct = ProductDetail.create(productCategory,name,image,content,amount);
        ProductDetail saveProduct = productDetailRepository.save(createProduct);
        return saveProduct.getId();
    }

    /**
     * 수정
     * @param id
     * @param name
     * @param image
     * @param content
     * @param amount
     */
    @Transactional
    public void updateProductDetail(Long id, String name, String image, String content, int amount){
        ProductDetail productDetail = productDetailRepository.findById(id).orElseThrow();
        productDetail.setName(name);
        productDetail.setImage(image);
        productDetail.setContent(content);
        productDetail.setAmount(amount);
    }
}
