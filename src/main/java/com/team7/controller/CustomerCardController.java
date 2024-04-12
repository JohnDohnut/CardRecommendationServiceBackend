package com.team7.controller;


import com.team7.service.relationship.CardBenefitService;
import com.team7.service.entitiy.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerCardController {

    @GetMapping("/{id}/myCards")
    public void doSomething(){

    }



}

