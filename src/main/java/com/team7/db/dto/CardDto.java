package com.team7.db.dto;


import com.team7.model.entity.Benefit;
import com.team7.model.entity.Card;
import com.team7.model.entity.CardVendor;
import com.team7.model.entity.Mbti;
import com.team7.model.relationship.CardBenefit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter

public class CardDto {
    private Long cardUid;

    private String name;

    private String type;

    private Long annualFee;

    private int available;

    private byte[] image;

    private CardVendor cardVendor;

    private Mbti mbti;

    ArrayList<BenefitDto> benefits;


    public CardDto(Card card){
        this.cardUid = card.getCardUid();
        this.name = card.getName();
        this.type = card.getType();
        this.annualFee = card.getAnnualFee();
        this.available = card.getAvailable();
        this.image = card.getImage();
        this.cardVendor = card.getCardVendor();
        this.mbti = card.getMbti();
        benefits = new ArrayList<>(card.getCardBenefits()
                .stream()
                .map(cardBenefit -> new BenefitDto(cardBenefit))
                .collect(Collectors.toList()));

    }
}
