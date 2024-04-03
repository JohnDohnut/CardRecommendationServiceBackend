package com.team7.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "card_vendor")
public class CardVendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_vendor_uid")
    private Long vendorUid;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    // 생성자, getter, setter...
}