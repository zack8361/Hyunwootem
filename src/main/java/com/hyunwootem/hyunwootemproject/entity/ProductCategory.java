package com.hyunwootem.hyunwootemproject.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.GenerationType.IDENTITY;
import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@ToString(of = {"id","name","image"})
public class ProductCategory {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "product_category_id")
    private Long id;

    private String name;
    private String image;

    @OneToMany(mappedBy = "productCategory",cascade = ALL)
    private List<ProductDetail> productDetailList = new ArrayList<>();

    public ProductCategory(String name, String image) {
        this.name = name;
        this.image = image;
    }

    // 생성 메서드
    public static ProductCategory create(String name, String image){
        requireNonNull(name);
        requireNonNull(image);
        return new ProductCategory(name,image);
    }
}
