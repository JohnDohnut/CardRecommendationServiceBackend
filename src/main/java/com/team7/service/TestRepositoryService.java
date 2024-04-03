package com.team7.service;

import com.team7.model.Test;
import com.team7.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
@Qualifier("TestService")
public class TestRepositoryService {
    private final TestRepository testRepository;
    public Test findTestById(Long id) {
        return testRepository.findTestById(id);
    }
}
