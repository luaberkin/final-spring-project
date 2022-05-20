package com.example.finalproject.controller;


import com.example.finalproject.models.Answer;
import com.example.finalproject.service.impl.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping
    public ResponseEntity<List<Answer>> findAll(){
        List<Answer> answerList = answerService.findAll();
        if(answerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else{
            return new ResponseEntity<>(answerList, HttpStatus.OK);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Answer> findById(@PathVariable("id") Long id){
        Optional<Answer> answer = answerService.findOne(id);
        if(answer.isPresent()){
            return new ResponseEntity<>(answer.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<Answer> getAnswerByQuestionId(@PathVariable("id") Long id){
        Optional<Answer> answer = answerService.getAnswerByQuestionId(id);
        if(answer.isPresent()){
            return new ResponseEntity<>(answer.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Answer> save(@RequestBody Answer answer){
        try{
            answerService.save(answer);
            return new ResponseEntity<>(answer, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Answer> update(@PathVariable("id") Long id, @RequestBody Answer answer){
        try{
            Answer updated = answerService.update(id, answer);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id){
        try{
            answerService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAll(){
        try{
            answerService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
