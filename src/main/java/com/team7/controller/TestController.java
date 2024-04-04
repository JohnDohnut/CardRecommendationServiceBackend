package com.team7.controller;

import com.team7.model.entity.Card;
import com.team7.model.entity.CardVendor;
import com.team7.service.CardService;
import com.team7.service.CardVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class TestController {
    public final CardService cardService;

}
