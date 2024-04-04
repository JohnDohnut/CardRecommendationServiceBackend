package com.team7.controller;

import com.team7.model.entity.Card;
import com.team7.model.entity.CardVendor;
import com.team7.service.CardService;
import com.team7.service.CardVendorService;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class TestController {
    public final CardService cardService;
    public final CardVendorService cardVendorService;
    @GetMapping("/testbed/vendorId")
    public CardVendor getVendorById(){
        CardVendor rv = cardVendorService.findCardVendorByCardVendorUid(Long.valueOf(1));
        System.out.println(rv.getName());
        return rv;
    }

    @GetMapping("/testbed/vendorName")
    public CardVendor getVendorByName(String name){
        CardVendor rv = cardVendorService.findCardVendorByName("우리카드");
        System.out.println(rv.getName());
        return rv;
    }
    @GetMapping("/testbed/cardName")
    public Card getCardByName(String name){
        Card rv = cardService.findCardByName("노리카드");
        return rv;
    }
}
