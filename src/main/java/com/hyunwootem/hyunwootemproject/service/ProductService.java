package com.hyunwootem.hyunwootemproject.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {


    @Transactional
    public Long createProductCategory(String name, String imageUrl) {
        

    }
}
