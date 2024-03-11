package com.hyunwootem.hyunwootemproject.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@ToString(of = {"id","name","image"})
public class ProductCategory {

    @Id @GeneratedValue
    @Column(name = "product_category_id")
    private Long id;

    private String name;
    private String image;

    @OneToMany(mappedBy = "productCategory")
    private List<ProductDetail> productDetailList = new ArrayList<>();
}
