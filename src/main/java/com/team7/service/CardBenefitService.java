package com.team7.service;


import com.team7.model.complex.CardBenefitUid;
import com.team7.model.relationship.CardBenefit;
import com.team7.repository.card.CardBenefitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CardBenefitService {

    private final CardBenefitRepository cardBenefitRepository;

    public ArrayList<CardBenefit> getCardBenefitByUid(CardBenefitUid cardBenefitUid){

       return cardBenefitRepository.findCardBenefitByCardBenefitUid(cardBenefitUid);

    }

    public ArrayList<CardBenefit> getCardBenefitByBenefitOn(String benefitOn) {

        return cardBenefitRepository.findCardBenefitByBenefitOn(benefitOn);

    }

    public ArrayList<CardBenefit> findCardBenefitByType(String type){

        return cardBenefitRepository.findCardBenefitByType(type);
    }

    public ArrayList<CardBenefit> findCardBenefitByUnit(String unit){

        return cardBenefitRepository.findCardBenefitByUnit(unit);

    }
}
