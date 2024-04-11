package com.team7.controller;

import com.team7.db.dto.CardDto;
import com.team7.model.entity.Benefit;
import com.team7.model.entity.Card;
import com.team7.service.relationship.CardBenefitService;
import com.team7.service.entitiy.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
public class CardInfoController {
    public final CardService cardService;
    public final CardBenefitService cardBenefitService;

    @GetMapping("/")
    public List<CardDto> showAllCards(){
        ArrayList<Card> cardList=cardService.findAll();
        List<CardDto> cardDtos = cardList.stream()
                .map(o->new CardDto(o))
                .collect(Collectors.toList());

        return cardDtos;
    }

    @GetMapping("/card/{id}")
    public CardDto CardgetCardByUid(@PathVariable Long id){
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
