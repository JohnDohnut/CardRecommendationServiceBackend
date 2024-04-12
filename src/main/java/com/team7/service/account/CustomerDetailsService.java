package com.team7.service.account;

import com.team7.model.entity.Customer;
import com.team7.repository.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CustomerDetailsService implements UserDetailsService {
    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        Customer customer = customerRepository.findCustomerByAccountId(username)
                .orElseThrow(()-> new UsernameNotFoundException("No such user"));
        user = new User(customer.getAccountId(), customer.getPassword(), customer.getAuthorities());
        return user;
    }

}
