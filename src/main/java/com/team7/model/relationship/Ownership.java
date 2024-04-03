package com.team7.model.relationship;

import com.team7.model.complex.OwnershipUid;
import com.team7.model.entity.Card;
import com.team7.model.entity.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "ownership")
public class Ownership {

    @EmbeddedId
    private OwnershipUid id = new OwnershipUid();

    @ManyToOne
    @MapsId("customerUid")
    @JoinColumn(name = "customer_uid")
    private Customer customer;

    @ManyToOne
    @MapsId("cardUid")
    @JoinColumn(name = "card_uid")
    private Card card;

    // 생성자, getter, setter...
}
