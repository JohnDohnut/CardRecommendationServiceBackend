package com.team7.service;

import com.team7.model.entity.Card;
import com.team7.model.entity.CardVendor;
import com.team7.repository.card.CardReopository;
import com.team7.repository.card.CardVendorRepository;

import java.util.ArrayList;

public class CardService {
    private CardReopository cardRepository;
    private CardVendorRepository cardVendorRepository;
    public ArrayList<Card> findCardByCardVendorName(String name){
        CardVendor cardVendor = cardVendorRepository.findCardVendorByName(name);
        ArrayList<Card> cards = cardRepository.findAllByCardVendor(cardVendor);
        return cards;
    }
    public ArrayList<Card> findCardByCardVendor(CardVendor cardVendor){
        return cardRepository.findAllByCardVendor(cardVendor);
    }
}
