package com.example.finalproject.controller;

import com.example.finalproject.models.Vacancy;
import com.example.finalproject.service.impl.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/vacancy")
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    @GetMapping
    public ResponseEntity<List<Vacancy>> findAll(){
        List<Vacancy> vacancyList = vacancyService.findAll();
        if(vacancyList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else{
            return new ResponseEntity<>(vacancyList, HttpStatus.OK);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Vacancy> findById(@PathVariable("id") Long id){
        Optional<Vacancy> vacancy = vacancyService.findOne(id);
        if(vacancy.isPresent()){
            return new ResponseEntity<>(vacancy.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byPosition")
    public ResponseEntity<List<Vacancy>> getVacancyByPosition(@RequestBody String position){
        List<Vacancy> vacancies = vacancyService.getVacancyByPosition(position);
        if(!vacancies.isEmpty()){
            return new ResponseEntity<>(vacancies, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/bySalary")
    public ResponseEntity<List<Vacancy>> getBetweenSalaryMinAndMax(@RequestParam("salaryMin") Integer salaryMin,
                                                                   @RequestParam("salaryMax") Integer salaryMax){
        List<Vacancy> vacancies = vacancyService.getBetweenSalaryMinAndMax(salaryMin, salaryMax);
        if(!vacancies.isEmpty()){
            return new ResponseEntity<>(vacancies, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<Vacancy> save(@RequestBody Vacancy vacancy){
        try{
            vacancyService.save(vacancy);
            return new ResponseEntity<>(vacancy, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vacancy> update(@PathVariable("id") Long id, @RequestBody Vacancy vacancy){
        try{
            Vacancy updated = vacancyService.update(id, vacancy);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id){
        try{
            vacancyService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAll(){
        try{
            vacancyService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
