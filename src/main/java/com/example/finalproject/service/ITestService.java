package com.example.finalproject.service;

import com.example.finalproject.models.Test;

import java.util.List;
import java.util.Optional;

public interface ITestService {
    Optional<Test> findOne(Long id);

    List<Test> findAll();

    Test save(Test entity);

    Test update(Long id, Test entity);

    void deleteAll();

    void deleteById(Long id);

    Optional<Test> getTestWithQuestionsById(Long id);
}
