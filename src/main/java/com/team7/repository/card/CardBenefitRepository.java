package com.team7.repository.card;

import com.team7.model.complex.CardBenefitUid;
import com.team7.model.entity.Benefit;
import com.team7.model.relationship.CardBenefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CardBenefitRepository extends JpaRepository<CardBenefit, CardBenefitUid> {

    public CardBenefit findCardBenefitByCardBenefitUid(CardBenefitUid cardBenefitUid);

    public ArrayList<CardBenefit> findCardBenefitByBenefitOn(String benefitOn);

    public ArrayList<CardBenefit> findCardBenefitByType(String type);

    public ArrayList<CardBenefit> findCardBenefitByUnit(String unit);

}
