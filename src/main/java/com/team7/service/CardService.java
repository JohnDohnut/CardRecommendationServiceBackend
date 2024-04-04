package com.team7.service;

import com.team7.model.entity.Card;
import com.team7.model.entity.CardVendor;
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
    public ArrayList<Card> findCardByCardVendorName(String name){
        CardVendor cardVendor = cardVendorRepository.findCardVendorByName(name);
        ArrayList<Card> cards = cardRepository.findAllByCardVendor(cardVendor);
        return cards;
    }
    public ArrayList<Card> findCardByCardVendor(CardVendor cardVendor){
        return cardRepository.findAllByCardVendor(cardVendor);
    }


    public Card findCardByName(String name){
        return cardRepository.findCardByName(name);
    }
}
