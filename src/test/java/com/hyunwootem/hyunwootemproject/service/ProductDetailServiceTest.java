package com.hyunwootem.hyunwootemproject.service;

import com.hyunwootem.hyunwootemproject.dto.request.ProductDetailRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback(false)
class ProductDetailServiceTest {
    @Autowired private ProductDetailService productDetailService;

    @Test
    void create() throws Exception {
        //given
        for(int i = 0; i<10; i++) {
            Long productDetail = productDetailService.createProductDetail(1L, "전선1부품", "img src1", "이것은 전선 1에대한 설명", 1);
            System.out.println("productDetail = " + productDetail + ": 생성 완료");
            //when
        }
    }
}