package com.example.finalproject.controller;


import com.example.finalproject.models.Test;
import com.example.finalproject.service.impl.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping
    public ResponseEntity<List<Test>> findAll(){
        List<Test> testList = testService.findAll();
        if(testList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else{
            return new ResponseEntity<>(testList, HttpStatus.OK);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Test> findById(@PathVariable("id") Long id){
        Optional<Test> test = testService.findOne(id);
        if(test.isPresent()){
            return new ResponseEntity<>(test.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/questions/{id}")
    public ResponseEntity<Test> getTestWithQuestionsById(@PathVariable("id") Long id){
        Optional<Test> test = testService.getTestWithQuestionsById(id);
        if(test.isPresent()){
            return new ResponseEntity<>(test.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Test> save(@RequestBody Test test){
        try{
            testService.save(test);
            return new ResponseEntity<>(test, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Test> update(@PathVariable("id") Long id, @RequestBody Test test){
        try{
            Test updated = testService.update(id, test);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id){
        try{
            testService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAll(){
        try{
            testService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
