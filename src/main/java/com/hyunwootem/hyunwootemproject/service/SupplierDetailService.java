package com.hyunwootem.hyunwootemproject.service;


import com.hyunwootem.hyunwootemproject.entity.SupplierCategory;
import com.hyunwootem.hyunwootemproject.entity.SupplierDetail;
import com.hyunwootem.hyunwootemproject.repository.SupplierCategoryRepository;
import com.hyunwootem.hyunwootemproject.repository.SupplierDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static lombok.AccessLevel.*;

@Service
@RequiredArgsConstructor(access = PROTECTED)
@Transactional(readOnly = true)
public class SupplierDetailService {

    private final SupplierDetailRepository supplierDetailRepository;
    private final SupplierCategoryRepository supplierCategoryRepository;

    /**
     * Supplier - Detail 생성
     * @param id
     * @param name
     * @param image
     * @param content
     * @param url
     * @return
     */
    @Transactional
    public Long createSupplierDetail(Long id, String name, String image, String content, String url){
        SupplierCategory supplierCategory = supplierCategoryRepository.findById(id).orElseThrow();
        SupplierDetail supplierDetail = SupplierDetail.create(supplierCategory, name, image, content, url);
        SupplierDetail save = supplierDetailRepository.save(supplierDetail);
        return save.getId();
    }


}
