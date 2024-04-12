package com.team7.controller;

import com.team7.db.dto.CardDto;
import com.team7.model.entity.Benefit;
import com.team7.model.entity.Card;
import com.team7.service.relationship.CardBenefitService;
import com.team7.service.entitiy.CardService;
import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.stream.Collectors;
>>>>>>> 308e3c8dd21fb6a5b2777811aa31670508629e57

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(originPatterns = "http://localhost:3000",allowCredentials = "true")
@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/cards")
public class CardInfoController {
    public final CardService cardService;
    public final CardBenefitService cardBenefitService;

    @GetMapping("/")
<<<<<<< HEAD
    public List<CardDto> showAllCards(){
        ArrayList<Card> cardList=cardService.findAll();
        List<CardDto> cardDtos = cardList.stream()
                .map(o->new CardDto(o))
                .collect(Collectors.toList());

        return cardDtos;
    }

    @GetMapping("/card/{id}")
    public CardDto CardgetCardByUid(@PathVariable Long id){
=======
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
>>>>>>> 308e3c8dd21fb6a5b2777811aa31670508629e57
        Card card = cardService.findCardByCardUid(id);
        CardDto rv = new CardDto(card);
        return rv;
    }

    @GetMapping("/{type}")
    public List<CardDto> showByType(@PathVariable String type) {
        String convertType="";
        if(type.equals("credit")){
            convertType="신용";
        }
        else if(type.equals("check")){
            convertType="체크";
        }
        ArrayList<Card> cardList = cardService.findCardsByType(convertType);
        List<CardDto> cardDtos = cardList.stream()
                .map(card -> new CardDto(card))
                .collect(Collectors.toList());

        return cardDtos;
    }

}
