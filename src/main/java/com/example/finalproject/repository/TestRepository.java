package com.example.finalproject.repository;

import com.example.finalproject.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Test,Long> {


    @Query("select t from Test t " +
            "left join Question q on t = q.testId ")
    Optional<Test> getTestWithQuestionsById(Long id);
}
