package com.team7.dto;

import com.team7.model.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class CustomerInfoDTO {


    private String firstName;
    private String lastName;
    private Date birth;
    private String phone;
    private String email;
    private String accountId;

    public CustomerInfoDTO(Customer customer){
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.birth = customer.getBirth();
        this.phone = customer.getPhone();
        this.email = customer.getEmail();
        this.accountId = customer.getAccountId();
    }

}
