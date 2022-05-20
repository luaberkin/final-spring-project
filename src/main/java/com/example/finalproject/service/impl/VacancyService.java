package com.example.finalproject.service.impl;

import com.example.finalproject.models.Vacancy;
import com.example.finalproject.repository.VacancyRepository;
import com.example.finalproject.service.IVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacancyService implements IVacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

    @Override
    public Optional<Vacancy> findOne(Long id) {
        return vacancyRepository.findById(id);
    }

    @Override
    public List<Vacancy> findAll() {
        return vacancyRepository.findAll();
    }

    @Override
    public Vacancy save(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    @Override
    public Vacancy update(Long id, Vacancy entity) {
        Optional<Vacancy> vacancy = vacancyRepository.findById(id);
        if(vacancy.isPresent()){
            Vacancy vacancy1 = vacancy.get();
            vacancy1.setTestId(entity.getTestId());
            vacancy1.setAddress(entity.getAddress());
            vacancy1.setEmployeeVacancies(entity.getEmployeeVacancies());
            vacancy1.setDescription(entity.getDescription());
            vacancy1.setName(entity.getName());
            vacancy1.setPlacementCellId(entity.getPlacementCellId());
            vacancy1.setPosition(entity.getPosition());
            vacancy1.setSalaryMin(entity.getSalaryMin());
            vacancy1.setSalaryMax(entity.getSalaryMax());
            return vacancyRepository.save(vacancy1);
        }
        return null;
    }

    @Override
    public void deleteAll() {
        vacancyRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        vacancyRepository.deleteById(id);
    }

    @Override
    public List<Vacancy> getVacancyByPosition(String position) {
        return vacancyRepository.getVacancyByPosition(position);
    }

    @Override
    public List<Vacancy> getBetweenSalaryMinAndMax(Integer salaryMin, Integer salaryMax) {
        return vacancyRepository.getBetweenSalaryMinAndMax(salaryMin, salaryMax);
    }
}
