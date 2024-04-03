package com.team7.model.relationship;

import com.team7.model.entity.Customer;
import jakarta.persistence.*;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "customer_account")
public class CustomerAccount {

    @Id
    @Column(name = "customer_uid")
    private Long customerId;

    @Column(name = "id", length = 20, nullable = false)
    private String id;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "customer_uid", referencedColumnName = "customer_uid", insertable = false, updatable = false)
    private Customer customer;

    // 생성자, getter, setter...
}
