package com.example.finalproject.service;

import com.example.finalproject.models.Vacancy;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IVacancyService {
    Optional<Vacancy> findOne(Long id);

    List<Vacancy> findAll();

    Vacancy save(Vacancy entity);

    Vacancy update(Long id, Vacancy entity);

    void deleteAll();

    void deleteById(Long id);

    List<Vacancy> getVacancyByPosition(String position);

    List<Vacancy> getBetweenSalaryMinAndMax(Integer salaryMin, Integer salaryMax);

}
