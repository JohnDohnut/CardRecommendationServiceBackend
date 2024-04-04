package com.team7.repository.card;

import com.team7.model.complex.CardBenefitUid;
import com.team7.model.relationship.CardBenefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardBenefitRepository extends JpaRepository<CardBenefit, CardBenefitUid> {

    public CardBenefit findCardBenefitByCardBenefitUid(CardBenefitUid cardBenefitUid);


}
