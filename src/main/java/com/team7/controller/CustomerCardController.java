package com.team7.controller;


import com.team7.dto.CardDto;
import com.team7.model.entity.Card;
import com.team7.model.relationship.Ownership;
import com.team7.service.entitiy.CustomerService;
import com.team7.service.relationship.CardBenefitService;
import com.team7.service.entitiy.CardService;
import com.team7.service.relationship.OwnershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
@ResponseBody
public class CustomerCardController {
    private final CustomerService customerService;
    private final OwnershipService ownershipService;
    @GetMapping("/myCards")
    public ArrayList<CardDto> getCustomerCards(){
        String customerAccountId = SecurityContextHolder.getContext().getAuthentication().getName();
        ArrayList<Ownership> ownerships = ownershipService.getOwnershipsByCustomer(
                customerService.findCustomerByAccountId(customerAccountId).get());
        ArrayList<CardDto> cards = new ArrayList<>(ownerships
                .stream()
                .map(ownership -> new CardDto(ownership.getCard()))
                .collect(Collectors.toList()));
        return cards;
    }



}

