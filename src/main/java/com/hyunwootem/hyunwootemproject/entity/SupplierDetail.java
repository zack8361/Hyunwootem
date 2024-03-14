package com.hyunwootem.hyunwootemproject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.FetchType.*;
import static lombok.AccessLevel.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
public class SupplierDetail {

    @Id @GeneratedValue
    @Column(name = "supplier_detail_id")
    private Long id;

    private String name;
    private String image;
    private String content;
    private String url;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "supplier_category_id")
    private SupplierCategory supplierCategory;

}
