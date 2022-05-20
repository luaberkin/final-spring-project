package com.example.finalproject.service;

import com.example.finalproject.models.EmployeeVacancy;

import java.util.List;
import java.util.Optional;

public interface IEmployeeVacancyService {
    
    Optional<EmployeeVacancy> findOne(Long id);

    List<EmployeeVacancy> findAll();

    EmployeeVacancy save(EmployeeVacancy entity);

    EmployeeVacancy update(Long id, EmployeeVacancy entity);

    void deleteAll();

    void deleteById(Long id);
}
