package com.team7.controller;

import com.team7.db.dto.CardDto;
import com.team7.model.entity.Benefit;
import com.team7.model.entity.Card;
import com.team7.service.relationship.CardBenefitService;
import com.team7.service.entitiy.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class CardInfoController {
    public final CardService cardService;
    public final CardBenefitService cardBenefitService;


    @GetMapping("/cards/card/{id}")
    public CardDto CardgetCardByUid(@PathVariable Long id){
        Card card = cardService.findCardByCardUid(id);
        CardDto rv = new CardDto(card);
        return rv;
    }
}
