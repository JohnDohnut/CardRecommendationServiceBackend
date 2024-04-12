package com.team7.service.relationship;


import com.team7.model.entity.Benefit;
import com.team7.model.entity.Card;
import com.team7.model.relationship.CardBenefit;
import com.team7.repository.card.BenefitRepository;
import com.team7.repository.card.CardBenefitRepository;
import com.team7.repository.card.CardReopository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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


}