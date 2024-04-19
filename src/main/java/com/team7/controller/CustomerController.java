package com.team7.controller;


import com.team7.cloud.service.AwsS3Service;
import com.team7.controller.util.ControllerUtil;
import com.team7.db.dto.CardDto;
import com.team7.db.dto.CustomerInfoDTO;
import com.team7.db.dto.MyDataInfoDTO;
import com.team7.db.model.entity.MyData;
import com.team7.db.model.entity.User;
import com.team7.db.model.relationship.Ownership;
import com.team7.security.utils.JWTUtil;
import com.team7.service.entitiy.CustomerService;
import com.team7.service.entitiy.MyDataService;
import com.team7.service.relationship.OwnershipService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
@ResponseBody
public class CustomerController {
    private final AwsS3Service awsS3Service;
    private final CustomerService customerService;
    private final OwnershipService ownershipService;
    private final MyDataService myDataService;

    private final ControllerUtil controllerUtil;



    @GetMapping("/myInfo")
    public CustomerInfoDTO getCustomerInfo(HttpServletRequest request, HttpServletResponse response){
        String customerAccountId = controllerUtil.getUserNameFromHeader(request);
        Optional<User> customer = customerService.findUserByAccountId(customerAccountId);
        return customer.map(CustomerInfoDTO::new).orElse(null);
    }

    @PostMapping("/myInfo/modify/email")
    public String CustomerInfoDTO(HttpServletRequest request, HttpServletResponse response){
        return null;
    }

    @GetMapping("/myCards")
    public ArrayList<CardDto> getCustomerCards(HttpServletRequest request, HttpServletResponse response) {
        String customerAccountId = controllerUtil.getUserNameFromHeader(request);

        ArrayList<Ownership> ownerships = ownershipService.getOwnershipsByCustomer(
                customerService.findUserByAccountId(customerAccountId).get());
        ArrayList<CardDto> cards = new ArrayList<>(ownerships
                .stream()
                .map(ownership -> new CardDto(ownership.getCard(), awsS3Service))
                .collect(Collectors.toList()));
        return cards;
    }

    @GetMapping("/myData")
    public MyDataInfoDTO getCustomerMyData(HttpServletRequest request, HttpServletResponse response){
        String customerAccountId = controllerUtil.getUserNameFromHeader(request);
        Optional<User> customer = customerService.findUserByAccountId(customerAccountId);
        Optional<MyData> myData = myDataService.findMyDataByCustomer(customer.get());
        return myData.map(MyDataInfoDTO::new).orElse(null);

    }
}

