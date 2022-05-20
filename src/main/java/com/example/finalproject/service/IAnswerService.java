package com.example.finalproject.service;

import com.example.finalproject.models.Answer;

import java.util.List;
import java.util.Optional;

public interface IAnswerService {
    Optional<Answer> findOne(Long id);

    List<Answer> findAll();

    Answer save(Answer entity);

    Answer update(Long id, Answer entity);

    void deleteAll();

    void deleteById(Long id);

    Optional<Answer> getAnswerByQuestionId(Long id);

}
