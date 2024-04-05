package com.team7.repository.card;

import com.team7.model.entity.Customer;
import com.team7.model.entity.Mbti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Customer findCustomerByCustomerUid(Long customerUid);

    public Customer findCustomerByPhone(String phone);

    public Customer findCustomerByEmail(String email);

    public ArrayList<Customer> findAllByBirth(Date birth);

    public Customer findCustomerByAccountIdAndAccountPassword(String accountId, String accountPassword);

    public ArrayList<Customer> findAllByAccountPassword(String accountPassword);

    public ArrayList<Customer> findAllByMbti(Mbti mbti);

    public ArrayList<Customer> findAllByMbtiValue(String mbtiValue);


}
