package com.hyunwootem.hyunwootemproject.repository;

import com.hyunwootem.hyunwootemproject.entity.ProductCategory;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductCategory,Long> {

    @Override
    @EntityGraph(attributePaths = {"productDetailList"})
    List<ProductCategory> findAll();
}
