package com.hyunwootem.hyunwootemproject.service;

import com.hyunwootem.hyunwootemproject.entity.SupplierCategory;
import com.hyunwootem.hyunwootemproject.repository.SupplierCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SupplierCategoryService {


    private final SupplierCategoryRepository supplierCategoryRepository;

    /**
     * 협력사 카테고리 생성
     * @param name
     * @return
     */
    @Transactional
    public Long createSupplierCategory(String name) {
        return supplierCategoryRepository.save(new SupplierCategory(name)).getId();
    }

    /**
     * 협력사 카테고리 수정
     * @param id
     * @param name
     */
    @Transactional
    public void updateSupplierCategory(Long id, String name) {
        SupplierCategory supplierCategory = supplierCategoryRepository.findById(id).orElseThrow();
        supplierCategory.setName(name);
    }
}
