package com.team7.repository.card;

import com.team7.model.entity.CardVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public interface CardVendorRepository extends JpaRepository<CardVendor, Long> {

    public CardVendor findCardVendorByName(String name);
    public CardVendor findCardVendorByCardVendorUid(Long cardVendorUid);


}
