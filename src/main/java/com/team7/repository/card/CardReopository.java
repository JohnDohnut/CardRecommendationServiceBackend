package com.team7.repository.card;

import com.team7.model.entity.Card;
import com.team7.model.entity.CardVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public interface CardReopository extends JpaRepository<Card, Long> {

    public ArrayList<Card> findAllByCardVendor(CardVendor cardVendor);
}
