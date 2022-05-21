package com.example.finalproject.service.impl;

import com.example.finalproject.models.Test;
import com.example.finalproject.repository.TestRepository;
import com.example.finalproject.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TestService implements ITestService{

    @Autowired
    private TestRepository testRepository;

    @Override
    @Transactional
    public Optional<Test> findOne(Long id) {
        return testRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Test> findAll() {
        return testRepository.findAll();
    }

    @Override
    @Transactional
    public Test save(Test test) {
        return testRepository.save(test);
    }

    @Override
    @Transactional
    public Test update(Long id, Test entity) {
        Optional<Test> test = testRepository.findById(id);
        if(test.isPresent()){
            Test test1 = test.get();
            test1.setName(entity.getName());
            test1.setQuestions(entity.getQuestions());
            test1.setVacancies(entity.getVacancies());
            return testRepository.save(test1);
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteAll() {
        testRepository.deleteAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        testRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<Test> getTestWithQuestionsById(Long id) {
        return testRepository.getTestWithQuestionsById(id);
    }
}
