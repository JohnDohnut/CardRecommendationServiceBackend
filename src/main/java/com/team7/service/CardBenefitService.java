package com.team7.service;


import com.team7.model.complex.CardBenefitUid;
import com.team7.model.entity.Benefit;
import com.team7.model.entity.Card;
import com.team7.model.relationship.CardBenefit;
import com.team7.repository.card.BenefitRepository;
import com.team7.repository.card.CardBenefitRepository;
import com.team7.repository.card.CardReopository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardBenefitService {

    private final CardBenefitRepository cardBenefitRepository;
    private final BenefitRepository benefitRepository;
    private final CardReopository cardReopository;

    public ArrayList<CardBenefit> getCardBenefitsByCard(Card card){

        ArrayList<CardBenefit> rv = cardBenefitRepository.findCardBenefitsByCard(card);
        return rv;
    }

    public ArrayList<CardBenefit> getCardBenefitsByBenefit(Benefit benefit){

        ArrayList<CardBenefit> rv = cardBenefitRepository.findCardBenefitsByBenefit(benefit);
        return rv;
    }

    public Set<Benefit> getBenefitsOfCard(Card card){
        System.out.println("get benefit invoked");
        ArrayList<CardBenefit> cardBenefits = cardBenefitRepository.findCardBenefitsByCard(card);

        Set<Benefit> benefits = cardBenefits
                .stream()
                .map(CardBenefit::getBenefit)
                .collect(Collectors.toSet());
        return benefits;

    }
}
