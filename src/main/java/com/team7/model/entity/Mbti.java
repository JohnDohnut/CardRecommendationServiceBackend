package com.team7.model.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "mbti")
public class Mbti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mbti_uid")
    private Long id;

    @Column(name = "mbti_value", length = 5, nullable = false)
    private String value;

    // 생성자, getter, setter...
}