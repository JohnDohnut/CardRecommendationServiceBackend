package com.team7.controller;

import com.team7.dto.CardDto;
import com.team7.model.entity.Card;
import com.team7.service.relationship.CardBenefitService;
import com.team7.service.entitiy.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.stream.Collectors;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class CardInfoController {
    public final CardService cardService;
    public final CardBenefitService cardBenefitService;

    @GetMapping("/cards/creditCards")
    public ArrayList<CardDto> getCreditCards(){
        ArrayList<CardDto> cards = new ArrayList<>(cardService.findCardsByType("신용")
                .stream()
                .map(card -> new CardDto(card))
                .collect(Collectors.toList()));
        return cards;
    }

    @GetMapping("/cards/prepaidCards")
    public ArrayList<CardDto> getPrepaidCards(){
        ArrayList<CardDto> cards = new ArrayList<>(cardService.findCardsByType("체크")
                .stream()
                .map(card -> new CardDto(card))
                .collect(Collectors.toList()));
        return cards;
    }



    @GetMapping("/cards/card/{id}")
    public CardDto getCardByUid(@PathVariable Long id){
        Card card = cardService.findCardByCardUid(id);
        CardDto rv = new CardDto(card);
        return rv;
    }
}
