package com.example.finalproject.repository;

import com.example.finalproject.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerRepository  extends JpaRepository<Answer, Long> {

    Optional<Answer> getAnswerByQuestionId(Long id);

}
