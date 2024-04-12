package com.team7.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CustomerInfoDto {

    private String firstName;
    private String lastName;
    private Date birth;
    private String phone;
    private String email;
    private String accountId;
    private String accountPassword;

}
