package com.team7.service;

import com.team7.model.entity.CardVendor;
import com.team7.model.entity.Customer;
import com.team7.model.entity.Mbti;
import com.team7.repository.card.CustomerRepository;
import com.team7.repository.card.MbtiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final MbtiRepository mbtiRepository;
    private final CustomerRepository customerRepository;

    public Customer findCustomerByCustomerUid(Long customerUid){
        return customerRepository.findCustomerByCustomerUid(customerUid);
    }

    public Customer findCustomerByPhone(String phone){
        return customerRepository.findCustomerByPhone(phone);
    }

    public Customer findCustomerByEmail(String email){
        return customerRepository.findCustomerByEmail(email);
    }

    public ArrayList<Customer> findCustomerByBirth(Date birth){
        ArrayList<Customer> customers = customerRepository.findAllByBirth(birth);
        return customers;
    }

    public Customer findCustomerByAccountId(String accountId, String accountPassword){
        return customerRepository.findCustomerByAccountIdAndAccountPassword(accountId, accountPassword);
    }

    public ArrayList<Customer> findCustomerByAccountPassword(String accountPassword){
        ArrayList<Customer> customers = customerRepository.findAllByAccountPassword(accountPassword);
        return customers;
    }

    public ArrayList<Customer> findCustomerByMbti(Mbti mbti){
        ArrayList<Customer> customers = customerRepository.findAllByMbti(mbti);
        return customers;
    }

    public ArrayList<Customer> findCustomerByMbtiValue(String mbtiValue){
        Mbti mbti = mbtiRepository.findMbtiByValue(mbtiValue);
        ArrayList<Customer> customers = customerRepository.findAllByMbti(mbti);
        return customers;
    }


}
