package com.team7.repository.card;

import com.team7.model.entity.Card;
import com.team7.model.entity.CardVendor;
import com.team7.model.entity.Mbti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface CardReopository extends JpaRepository<Card, Long> {

    public Card getCardByCardUid(Long uid);

    public Card findCardByCardUid(Long uid);

    public ArrayList<Card> findCardsByName(String name);

    public ArrayList<Card> findCardsByType(String type);

    public ArrayList<Card> findCardsByAvailable(int available);

    public ArrayList<Card> findCardsByCardVendor(CardVendor cardVendor);

    public ArrayList<Card> findCardsByMbti(Mbti mbti);


}
