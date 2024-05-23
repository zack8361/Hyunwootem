package com.hyunwootem.hyunwootemproject.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static lombok.AccessLevel.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
public class SupplierCategory {

    @Id @GeneratedValue
    @Column(name = "supplier_category_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "supplierCategory",cascade = ALL)
    private List<SupplierDetail> supplierDetailList = new ArrayList<>();
    public SupplierCategory(String name) {
        this.name = name;
    }
}
