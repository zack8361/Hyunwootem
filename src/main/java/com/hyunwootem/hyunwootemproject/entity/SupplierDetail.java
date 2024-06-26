package com.hyunwootem.hyunwootemproject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
public class SupplierDetail {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "supplier_detail_id")
    private Long id;

    private String name;
    private String image;
    private String content;
    private String url;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "supplier_category_id")
    private SupplierCategory supplierCategory;


    //== 연관관계 매핑 메서드 ==//
    public void setSupplierCategory(SupplierCategory supplierCategory) {
        this.supplierCategory = supplierCategory;
        supplierCategory.getSupplierDetailList().add(this);
    }

    public SupplierDetail(String name, String image, String content, String url, SupplierCategory supplierCategory) {
        this.name = name;
        this.image = image;
        this.content = content;
        this.url = url;
        setSupplierCategory(supplierCategory);
    }

    // 생성 메서드
    public static SupplierDetail create(SupplierCategory supplierCategory,String name,String image,String content,String url){
        return new SupplierDetail(name,image,content,url,supplierCategory);
    }
}
