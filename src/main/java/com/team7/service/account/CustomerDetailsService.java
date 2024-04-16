package com.team7.service.account;

import com.team7.db.model.entity.Customer;
import com.team7.db.repository.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

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
