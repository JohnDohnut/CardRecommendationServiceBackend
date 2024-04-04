package com.team7.repository.card;

import com.team7.model.entity.Mbti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MbtiRepository extends JpaRepository<Mbti, Long> {

    public Mbti findByValue(String value);
}
