package com.team7.db.dto;


import com.team7.db.model.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CustomerRegisterDto {

    private String firstName;
    private String lastName;
    private Date birth;
    private String phone;
    private String email;
    private String accountId;
    private String accountPassword;

    public CustomerRegisterDto(User user){
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.birth = user.getBirth();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.accountId = user.getAccountId();
        this.accountPassword = user.getAccountPassword();
    }
}
