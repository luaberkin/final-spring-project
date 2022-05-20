package com.example.finalproject.controller;

import com.example.finalproject.models.EmployeeVacancy;
import com.example.finalproject.service.impl.EmployeeVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employee-vacancy")
public class EmployeeVacancyController {

    @Autowired
    private EmployeeVacancyService employeeVacancyService;

    @GetMapping
    public ResponseEntity<List<EmployeeVacancy>> findAll(){
        List<EmployeeVacancy> employeeVacancyList = employeeVacancyService.findAll();
        if(employeeVacancyList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else{
            return new ResponseEntity<>(employeeVacancyList, HttpStatus.OK);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeVacancy> findById(@PathVariable("id") Long id){
        Optional<EmployeeVacancy> employeeVacancy = employeeVacancyService.findOne(id);
        if(employeeVacancy.isPresent()){
            return new ResponseEntity<>(employeeVacancy.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<EmployeeVacancy> save(@RequestBody EmployeeVacancy employeeVacancy){
        try{
            employeeVacancyService.save(employeeVacancy);
            return new ResponseEntity<>(employeeVacancy, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeVacancy> update(@PathVariable("id") Long id, @RequestBody EmployeeVacancy employeeVacancy){
        try{
            EmployeeVacancy updated = employeeVacancyService.update(id, employeeVacancy);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id){
        try{
            employeeVacancyService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAll(){
        try{
            employeeVacancyService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
