package com.team7.service.complexed;


import com.team7.dto.CardDto;
import com.team7.model.entity.Benefit;
import com.team7.model.entity.Card;
import com.team7.model.relationship.CardBenefit;
import com.team7.repository.card.BenefitRepository;
import com.team7.repository.card.CardBenefitRepository;
import com.team7.repository.card.CardReopository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;


@Getter
@RequiredArgsConstructor
@Service
public class CardInfoService {
    private final CardReopository cardReopository;
    private final BenefitRepository benefitRepository;
    private final CardBenefitRepository cardBenefitRepository;

    public CardDto getCardDtoByCard(Card card){
        return new CardDto(card);
    }

    public ArrayList<Benefit> getBenefitsByCard (Card card){
        ArrayList<Benefit> rv  = new ArrayList<>(
                cardBenefitRepository
                .findCardBenefitsByCard(card)
                .stream()
                .map(CardBenefit::getBenefit)
                .collect(Collectors.toList()));
        return rv;
    }

}