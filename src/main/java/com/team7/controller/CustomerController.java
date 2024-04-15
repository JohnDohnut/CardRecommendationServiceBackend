package com.team7.controller;


import com.team7.dto.CardDto;
import com.team7.dto.CustomerInfoDTO;
import com.team7.model.entity.Customer;
import com.team7.model.relationship.Ownership;
import com.team7.security.utils.JWTUtil;
import com.team7.service.entitiy.CustomerService;
import com.team7.service.relationship.OwnershipService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
@ResponseBody
public class CustomerController {
    private final CustomerService customerService;
    private final OwnershipService ownershipService;
    private final JWTUtil jwtUtil;
    @GetMapping("/myInfo")
    public CustomerInfoDTO getCustomerInfo(HttpServletRequest request, HttpServletResponse response){
        String token = request.getHeader("Authorization").split(" ")[1];
        String customerAccountId = jwtUtil.getUsername(token);
        Optional<Customer> customer = customerService.findCustomerByAccountId(customerAccountId);
        return customer.map(CustomerInfoDTO::new).orElse(null);
    }

    @GetMapping("/myCards")
    public ArrayList<CardDto> getCustomerCards(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("Authorization").split(" ")[1];

        String customerAccountId = jwtUtil.getUsername(token);

        ArrayList<Ownership> ownerships = ownershipService.getOwnershipsByCustomer(
                customerService.findCustomerByAccountId(customerAccountId).get());
        ArrayList<CardDto> cards = new ArrayList<>(ownerships
                .stream()
                .map(ownership -> new CardDto(ownership.getCard()))
                .collect(Collectors.toList()));
        return cards;
    }
}

