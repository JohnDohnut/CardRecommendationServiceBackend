package com.team7.model.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_uid")
    private Long cardUid;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "type", length = 10, nullable = false)
    private String type;

    @Column(name = "available", nullable = false)
    private int available;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "vendor", referencedColumnName = "card_vendor_uid", nullable = false)
    private CardVendor vendor;

    @ManyToOne
    @JoinColumn(name = "mbti", referencedColumnName = "mbti_uid", nullable = false)
    private Mbti mbti;

    // 생성자, getter, setter...
}