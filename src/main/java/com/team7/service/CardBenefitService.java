package com.team7.service;


import com.team7.model.complex.CardBenefitUid;
import com.team7.model.relationship.CardBenefit;
import com.team7.repository.card.CardBenefitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardBenefitService {

    private final CardBenefitRepository cardBenefitRepository;

    public CardBenefit getCardBenefitByUid(CardBenefitUid cardBenefitUid){

       return cardBenefitRepository.findCardBenefitByCardBenefitUid(cardBenefitUid);

    }
}
