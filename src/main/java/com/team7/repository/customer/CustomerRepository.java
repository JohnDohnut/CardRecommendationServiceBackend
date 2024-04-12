package com.team7.repository.customer;

import com.team7.model.entity.Customer;
import com.team7.model.entity.Mbti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Optional<Customer> findCustomerByCustomerUid(Long customerUid);

    public Optional<Customer> findCustomerByPhone(String phone);

    public Optional<Customer> findCustomerByEmail(String email);


    public Optional<Customer> findCustomerByAccountIdAndAccountPassword(String accountId, String accountPassword);

    public ArrayList<Customer> findAllByAccountPassword(String accountPassword);

    public ArrayList<Customer> findAllByMbti(Mbti mbti);

    public ArrayList<Customer> findAllByMbtiValue(String mbtiValue);

    public Optional<Customer> findCustomerByAccountId(String accountId);


}
