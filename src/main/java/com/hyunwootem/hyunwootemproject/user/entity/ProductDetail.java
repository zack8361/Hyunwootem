package com.hyunwootem.hyunwootemproject.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.FetchType.*;
import static java.util.Objects.requireNonNull;

@Entity
@Getter
@Setter
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


    //== 연관관계 메서드 매핑 ==//
    private void setProductCategory(ProductCategory productCategory){
        this.productCategory = productCategory;
        productCategory.getProductDetailList().add(this);
    }

    public ProductDetail(String name, String image, String content, int amount, ProductCategory productCategory) {
        this.name = name;
        this.image = image;
        this.content = content;
        this.amount = amount;
        setProductCategory(productCategory);
    }

    public static ProductDetail create(ProductCategory productCategory,
                                       String name,
                                       String image,
                                       String content,
                                       int amount){
        requireNonNull(productCategory);
        requireNonNull(name);
        requireNonNull(image);
        requireNonNull(content);
        if(amount == 0){
            amount = 1;
        }
        return new ProductDetail(name,image,content,amount,productCategory);
    }
}