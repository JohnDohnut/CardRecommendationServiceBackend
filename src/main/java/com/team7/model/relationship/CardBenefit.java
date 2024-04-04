package com.team7.model.relationship;

import com.team7.model.complex.CardBenefitUid;
import com.team7.model.entity.Benefit;
import com.team7.model.entity.Card;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "card_benefit")
public class CardBenefit {

    @EmbeddedId
    private CardBenefitUid cardBenefitUid = new CardBenefitUid();

    @ManyToOne
    @MapsId("cardUid")
    @JoinColumn(name = "card_uid")
    private Card card;

    @ManyToOne
    @MapsId("benefitUid")
    @JoinColumn(name = "benefit_uid")
    private Benefit benefit;

    @Column(name = "amount", nullable = false)
    private int amount;

    // 생성자, getter, setter...
}

