package com.team7.service.entitiy;

import com.team7.db.model.entity.User;
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

    public Optional<User> findCustomerByCustomerUid(Long customerUid){
        return customerRepository.findUserByUid(customerUid);
    }

    public Optional<User> findUserByPhone(String phone){
        return customerRepository.findUserByPhone(phone);
    }

    public Optional<User> findUserByEmail(String email){
        return customerRepository.findUserByEmail(email);
    }


    public Optional<User> findUserByAccountId(String accountId){
        return customerRepository.findUserByAccountId(accountId);
    }

    public ArrayList<User> findUserByAccountPassword(String accountPassword){
        ArrayList<User> users = customerRepository.findAllByAccountPassword(accountPassword);
        return users;
    }

    public ArrayList<User> findUserByMbti(Mbti mbti){
        ArrayList<User> users = customerRepository.findAllByMbti(mbti);
        return users;
    }

    public ArrayList<User> findUserByMbtiValue(String mbtiValue){
        Mbti mbti = mbtiRepository.findMbtiByValue(mbtiValue);
        ArrayList<User> users = customerRepository.findAllByMbti(mbti);
        return users;
    }

    public User save(User user){
        return customerRepository.save(user);
    }

}
