package com.team7.service.entitiy;

import com.team7.model.entity.Card;
import com.team7.model.entity.CardVendor;
import com.team7.model.entity.Mbti;
import com.team7.repository.card.CardBenefitRepository;
import com.team7.repository.card.CardReopository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardReopository cardRepository;

    public Card findCardByCardUid(Long uid){
        Card rv = cardRepository.findCardByCardUid(uid);
        return rv;
    }

    public ArrayList<Card> findCardsByName(String name){
        ArrayList<Card> rv = cardRepository.findCardsByName(name);
        return rv;
    }

    public ArrayList<Card> findCardsByType(String type){
        ArrayList<Card> rv = cardRepository.findCardsByType(type);
        return rv;
    }

    public ArrayList<Card> findCardsByAvailable(int available){
        ArrayList<Card> rv = cardRepository.findCardsByAvailable(available);
        return rv;
    }
    public ArrayList<Card> findCardsByCardVendor(CardVendor cardVendor){
        ArrayList<Card> rv = cardRepository.findCardsByCardVendor(cardVendor);
        return rv;
    }

    public ArrayList<Card> findCardsByMbti(Mbti mbti){
        ArrayList<Card> rv = cardRepository.findCardsByMbti(mbti);
        return rv;
    }



}

