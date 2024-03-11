package com.hyunwootem.hyunwootemproject.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor
public class ProductDetail {

    @Id @GeneratedValue
    @Column(name = "product_detail_id")
    private Long id;

    private String name;
    private String image;
    private String content;
    private int amount;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;
}
