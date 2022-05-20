package com.example.finalproject.service.impl;

import com.example.finalproject.models.EmployeeVacancy;
import com.example.finalproject.repository.EmployeeVacancyRepository;
import com.example.finalproject.service.IEmployeeVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeVacancyService implements IEmployeeVacancyService{

    @Autowired
    private EmployeeVacancyRepository employeeVacancyRepository;

    @Override
    public Optional<EmployeeVacancy> findOne(Long id) {
        return employeeVacancyRepository.findById(id);
    }

    @Override
    public List<EmployeeVacancy> findAll() {
        return employeeVacancyRepository.findAll();
    }

    @Override
    public EmployeeVacancy save(EmployeeVacancy employeeVacancy) {
        return employeeVacancyRepository.save(employeeVacancy);
    }

    @Override
    public EmployeeVacancy update(Long id, EmployeeVacancy entity) {
        Optional<EmployeeVacancy> employeeVacancy = employeeVacancyRepository.findById(id);
        if(employeeVacancy.isPresent()){
            EmployeeVacancy employeeVacancy1 = employeeVacancy.get();
            employeeVacancy1.setEmployeeId(entity.getEmployeeId());
            employeeVacancy1.setVacancyId(entity.getVacancyId());
            return employeeVacancyRepository.save(employeeVacancy1);
        }
        return null;
    }

    @Override
    public void deleteAll() {
        employeeVacancyRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        employeeVacancyRepository.deleteById(id);
    }
}
