package com.team7.model.relationship;

import com.team7.model.complex.CustomerMbtiId;
import com.team7.model.entity.Customer;
import com.team7.model.entity.Mbti;
import jakarta.persistence.*;

@Entity
@Table(name = "customer_mbti")
public class CustomerMbti {

    @EmbeddedId
    private CustomerMbtiId id = new CustomerMbtiId();

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_uid")
    private Customer customer;

    @ManyToOne
    @MapsId("mbtiId")
    @JoinColumn(name = "mbti_uid")
    private Mbti mbti;

    // 생성자, getter, setter...
}