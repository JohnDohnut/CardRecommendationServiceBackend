package com.team7.model.relationship;

import com.team7.model.complex.OwnershipId;
import com.team7.model.entity.Card;
import com.team7.model.entity.Customer;
import jakarta.persistence.*;

@Entity
@Table(name = "ownership")
public class Ownership {

    @EmbeddedId
    private OwnershipId id = new OwnershipId();

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_uid")
    private Customer customer;

    @ManyToOne
    @MapsId("cardId")
    @JoinColumn(name = "card_uid")
    private Card card;

    // 생성자, getter, setter...
}
