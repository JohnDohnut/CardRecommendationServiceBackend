package com.team7.service;

import com.team7.model.entity.Mbti;
import com.team7.repository.card.MbtiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MbtiService {
    private final MbtiRepository mbtiRepository;

    public Mbti findMbtiByMbtiValue(String mbtiValue){
        return mbtiRepository.findMbtiByValue(mbtiValue);
    }
}
