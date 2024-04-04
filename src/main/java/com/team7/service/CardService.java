package com.team7.service;

import com.team7.model.entity.Card;
import com.team7.model.entity.CardVendor;
import com.team7.model.entity.Mbti;
import com.team7.repository.card.CardBenefitRepository;
import com.team7.repository.card.CardReopository;
import com.team7.repository.card.CardVendorRepository;
import com.team7.repository.card.MbtiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardReopository cardRepository;
    private final CardVendorRepository cardVendorRepository;
    private final MbtiRepository mbtiRepository;

    public ArrayList<Card> findCardsByCardUid(Long uid){
        ArrayList<Card> rv = cardRepository.findCardsByCardUid(uid);
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

