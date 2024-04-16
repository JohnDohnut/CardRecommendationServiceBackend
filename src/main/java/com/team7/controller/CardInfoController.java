package com.team7.controller;

import com.team7.dto.CardDto;
import com.team7.model.entity.Card;
import com.team7.service.relationship.CardBenefitService;
import com.team7.service.entitiy.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

@CrossOrigin(originPatterns = "http://localhost:5173")
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/cards")
public class CardInfoController {
    public final CardService cardService;
    public final CardBenefitService cardBenefitService;

    @GetMapping("/")
    public ArrayList<CardDto> getCards(){
        return cardService.cardsToCardDtos(cardService.findAllCards());
    }

    @GetMapping("/creditCards")
    public ArrayList<CardDto> getCreditCards(){
        ArrayList<CardDto> cards = new ArrayList<>(cardService.findCardsByType("신용")
                .stream()
                .map(card -> new CardDto(card))
                .collect(Collectors.toList()));
        return cards;
    }

    @GetMapping("/prepaidCards")
    public ArrayList<CardDto> getPrepaidCards(){
        ArrayList<CardDto> cards = new ArrayList<>(cardService.findCardsByType("체크")
                .stream()
                .map(card -> new CardDto(card))
                .collect(Collectors.toList()));
        return cards;
    }



    @GetMapping("/card/{id}")
    public CardDto getCardByUid(@PathVariable Long id){
        Card card = cardService.findCardByCardUid(id);
        CardDto rv = new CardDto(card);
        return rv;
    }
}