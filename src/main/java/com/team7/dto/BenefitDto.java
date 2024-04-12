package com.team7.dto;

import com.team7.model.entity.Benefit;
import com.team7.model.entity.Card;
import com.team7.model.relationship.CardBenefit;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BenefitDto {

    private Long benefitUid;

    private String benefitOn;

    private String type;

    private String unit;

    private int amount;

    public BenefitDto (CardBenefit cardBenefit){
        Benefit benefit = cardBenefit.getBenefit();
        this.benefitUid = benefit.getBenefitUid();
        this.benefitOn  = benefit.getBenefitOn();
        this.type = benefit.getType();
        this.unit = benefit.getUnit();
        this.amount = cardBenefit.getAmount();
    }

}
