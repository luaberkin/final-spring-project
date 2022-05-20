package com.example.finalproject.service;

import com.example.finalproject.models.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    Optional<Employee> findOne(Long id);

    List<Employee> findAll();

    Employee save(Employee entity);

    Employee update(Long id, Employee entity);

    void deleteAll();

    void deleteById(Long id);

    List<Employee> getEmployeesByPosition(String position);

    List<Employee> getEmployeeBySalary(Integer salaryMin, Integer salaryMax);
}
