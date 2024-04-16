package com.team7.db.model.entity;

import com.team7.db.dto.CustomerRegisterDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements UserDetails {

    public Customer (CustomerRegisterDto customerRegisterDto){
        this.customerUid = null;
        this.firstName = customerRegisterDto.getFirstName();
        this.lastName = customerRegisterDto.getLastName();
        this.birth = customerRegisterDto.getBirth();
        this.phone = customerRegisterDto.getPhone();
        this.email = customerRegisterDto.getEmail();
        this.accountId = customerRegisterDto.getAccountId();
        this.accountPassword = customerRegisterDto.getAccountPassword();
        this.accessToken = null;
        this.refreshToken = null;
        this.mbti = null;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_uid")
    private Long customerUid;

    @Column(name = "first_name", length = 20)
    private String firstName;

    @Column(name = "last_name", length = 20)
    private String lastName;

    @Column(length = 20)
    private String phone;

    @Column(length = 50)
    private String email;

    @Column(name = "birth")
    private Date birth;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "account_password")
    private String accountPassword;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "access_token")
    private String accessToken;

    @ManyToOne
    @JoinColumn(name = "mbti")
    private Mbti mbti;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getPassword() {
        return this.accountPassword;
    }

    @Override
    public String getUsername() {
        return this.accountId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    // 생성자, getter, setter...
}
