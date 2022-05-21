package com.example.finalproject.service.impl;

import com.example.finalproject.models.Question;
import com.example.finalproject.repository.QuestionRepository;
import com.example.finalproject.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService implements IQuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    @Transactional
    public Optional<Question> findOne(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    @Transactional
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    @Transactional
    public Question update(Long id, Question entity) {
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()){
            Question question1 = question.get();
            question1.setText(entity.getText());
            question1.setTestId(entity.getTestId());
            return questionRepository.save(question1);
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteAll() {
        questionRepository.deleteAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Question> getQuestionsByTestId(Long id) {
        return questionRepository.getQuestionsByTestId(id);
    }
}
