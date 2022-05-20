package com.example.finalproject.controller;

import com.example.finalproject.models.Question;
import com.example.finalproject.service.impl.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Question>> findAll(){
        List<Question> questionList = questionService.findAll();
        if(questionList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else{
            return new ResponseEntity<>(questionList, HttpStatus.OK);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Question> findById(@PathVariable("id") Long id){
        Optional<Question> question = questionService.findOne(id);
        if(question.isPresent()){
            return new ResponseEntity<>(question.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byTestId/{id}")
    public ResponseEntity<List<Question>> getQuestionsByTestId(@PathVariable("id") Long id){
        List<Question> questionList = questionService.getQuestionsByTestId(id);
        if(!questionList.isEmpty()){
            return new ResponseEntity<>(questionList, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Question> save(@RequestBody Question question){
        try{
            questionService.save(question);
            return new ResponseEntity<>(question, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> update(@PathVariable("id") Long id, @RequestBody Question question){
        try{
            Question updated = questionService.update(id, question);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id){
        try{
            questionService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAll(){
        try{
            questionService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
