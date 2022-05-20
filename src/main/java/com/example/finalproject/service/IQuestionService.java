package com.example.finalproject.service;

import com.example.finalproject.models.Question;

import java.util.List;
import java.util.Optional;

public interface IQuestionService {

    Optional<Question> findOne(Long id);

    List<Question> findAll();

    Question save(Question entity);

    Question update(Long id, Question entity);

    void deleteAll();

    void deleteById(Long id);

    List<Question> getQuestionsByTestId(Long id);

}
