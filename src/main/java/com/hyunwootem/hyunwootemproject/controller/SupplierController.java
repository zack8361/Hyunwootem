package com.hyunwootem.hyunwootemproject.controller;


import com.hyunwootem.hyunwootemproject.dto.request.SupplierCategoryRequestDto;
import com.hyunwootem.hyunwootemproject.dto.request.SupplierDetailRequestDto;
import com.hyunwootem.hyunwootemproject.repository.SupplierCategoryRepository;
import com.hyunwootem.hyunwootemproject.repository.SupplierDetailRepository;
import com.hyunwootem.hyunwootemproject.service.SupplierCategoryService;
import com.hyunwootem.hyunwootemproject.service.SupplierDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierCategoryRepository supplierCategoryRepository;
    private final SupplierDetailRepository supplierDetailRepository;

    private final SupplierCategoryService supplierCategoryService;
    private final SupplierDetailService supplierDetailService;
    // 협력사 카테고리 생성
    @PostMapping("/createSupplierCategory")
    public ResponseEntity<?> createSupplierCategory(@RequestBody SupplierCategoryRequestDto request) {
        Long supplierCategory = supplierCategoryService.createSupplierCategory(request.getName());
        System.out.println("supplierCategory = " + supplierCategory);
        return ResponseEntity.ok(200);
    }

    // 협력사 카테고리 읽기

    
    
    // 협력사 카테고리 수정
    @PutMapping("/updateSupplierCategory/{id}")
    public ResponseEntity<?> updateSupplierCategory(
            @PathVariable("id") Long id,
            @RequestBody SupplierCategoryRequestDto request){

        supplierCategoryService.updateSupplierCategory(id,request.getName());

        return ResponseEntity.ok(200);
    }
    // 협력사 카테고리 삭제
    @DeleteMapping("/deleteSupplierCategory/{id}")
    public ResponseEntity<?> deleteSupplierCategory(@PathVariable("id") Long id){

        supplierCategoryRepository.deleteById(id);

        return ResponseEntity.ok(200);
    }


    // 협력사 디테일 추가
    @PostMapping("/createSupplierDetail/{id}")
    public ResponseEntity<?> createSupplierDetail(
            @PathVariable("id") Long id,
            @RequestBody SupplierDetailRequestDto request){

        Long createId = supplierDetailService.createSupplierDetail(id, request.getName(), request.getImage(), request.getContent(), request.getUrl());
        System.out.println("createId = " + createId);
        return ResponseEntity.ok(200);
    }
}
