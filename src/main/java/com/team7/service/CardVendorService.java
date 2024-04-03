package com.team7.service;

import com.team7.model.entity.CardVendor;
import com.team7.repository.card.CardVendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CardVendorService {
    public final CardVendorRepository cardVendorRepository;

    public CardVendor findCardVendorByName(String name){
        return cardVendorRepository.findCardVendorByName(name);
    }

    public CardVendor findCardVendorByCardVendorUid(Long cardVendorUid){
        return cardVendorRepository.findCardVendorByCardVendorUid(cardVendorUid);
    }
}
