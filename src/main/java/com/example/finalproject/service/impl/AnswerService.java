package com.example.finalproject.service.impl;

import com.example.finalproject.models.Answer;
import com.example.finalproject.repository.AnswerRepository;
import com.example.finalproject.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService implements IAnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Optional<Answer> findOne(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Answer update(Long id, Answer entity) {
        Optional<Answer> answer = answerRepository.findById(id);
        if(answer.isPresent()){
            Answer answer1 = answer.get();
            answer1.setQuestionId(entity.getQuestionId());
            answer1.setScore(entity.getScore());
            answer1.setText(entity.getText());
            return answerRepository.save(answer1);
        }
        return null;
    }

    @Override
    public void deleteAll() {
        answerRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        answerRepository.deleteById(id);
    }

    @Override
    public Optional<Answer> getAnswerByQuestionId(Long id) {
        return answerRepository.getAnswerByQuestionId(id);
    }


}
