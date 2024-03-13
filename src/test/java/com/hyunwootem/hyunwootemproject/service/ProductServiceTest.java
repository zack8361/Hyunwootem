package com.hyunwootem.hyunwootemproject.service;

import com.hyunwootem.hyunwootemproject.entity.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
@Transactional
@Rollback(false)
class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @Test
    void create() throws Exception {
        //given
        for (int i = 0; i < 10; i++) {
            productService.createProductCategory("전선","img" + i);
        }
    }
    @Test
    void read() throws Exception {
        //given
        List<ProductCategory> allProduct = productService.findAllProduct();
        for (ProductCategory productCategory : allProduct) {
            System.out.println("productCategory = " + productCategory);
        }
    }

}