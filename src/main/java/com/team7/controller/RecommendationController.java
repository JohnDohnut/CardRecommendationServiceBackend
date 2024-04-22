package com.team7.controller;

import com.team7.controller.util.ControllerUtil;
import com.team7.db.model.entity.Mbti;
import com.team7.service.entitiy.CustomerService;
import com.team7.service.entitiy.MyDataService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/recommend")
@RequiredArgsConstructor
public class RecommendationController {

    private final MyDataService myDataService;
    private final CustomerService customerService;
    private final ControllerUtil controllerutil;

    @GetMapping("/member/mymbti")
    public RedirectView recommendByMyMbti(HttpServletRequest request, HttpServletResponse response){
        RedirectView redirectView = new RedirectView();

        Mbti mbti = customerService
                .findUserByAccountId(controllerutil.getUserNameFromHeader(request))
                .get()
                .getMbti();

        if(mbti == null){
            redirectView.setUrl("/cards");
        }

        else{
            redirectView.setUrl("/cards/mbti/" + mbti.getValue().toUpperCase());
        }

        return redirectView;
    }
    @GetMapping("/mbti/{mbti}")
    public RedirectView recommendByMbti(@PathVariable String mbti){
        RedirectView redirectView = new RedirectView();
        mbti = mbti.toUpperCase();
        redirectView.setUrl("/cards/mbti/" + mbti);
        return redirectView;
    }
//
//    @GetMapping("/mydata")
//    public ArrayList<CardDto> recommendByMyData(HttpServletRequest request, HttpServletResponse response){
//        User user = customerService.findUserByAccountId(controllerutil.getUserNameFromHeader(request)).get();
//        Optional<MyData> mydata = myDataService.findMyDataByCustomer(user);
//
//        if(mydata.isPresent()){
//            String lifeStage = mydata.get().getLifeStage();
//
//
//        }
//
//    }
}
