package com.team7.service.entitiy;

import com.team7.db.model.entity.Customer;
import com.team7.db.model.entity.Mbti;
import com.team7.db.repository.customer.CustomerRepository;
import com.team7.db.repository.card.MbtiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final MbtiRepository mbtiRepository;
    private final CustomerRepository customerRepository;

    public Optional<Customer> findCustomerByCustomerUid(Long customerUid){
        return customerRepository.findCustomerByCustomerUid(customerUid);
    }

    public Optional<Customer> findCustomerByPhone(String phone){
        return customerRepository.findCustomerByPhone(phone);
    }

    public Optional<Customer> findCustomerByEmail(String email){
        return customerRepository.findCustomerByEmail(email);
    }


    public Optional<Customer> findCustomerByAccountId(String accountId){
        return customerRepository.findCustomerByAccountId(accountId);
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

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

}
