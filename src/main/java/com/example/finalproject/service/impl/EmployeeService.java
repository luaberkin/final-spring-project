package com.example.finalproject.service.impl;

import com.example.finalproject.models.Employee;
import com.example.finalproject.repository.EmployeeRepository;
import com.example.finalproject.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> findOne(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long id, Employee entity) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            Employee employee1 = employee.get();
            employee1.setEmployeeRoles(entity.getEmployeeRoles());
            employee1.setEmployeeVacancies(entity.getEmployeeVacancies());
            employee1.setName(entity.getName());
            employee1.setPosition(entity.getPosition());
            employee1.setSalary(entity.getSalary());
            employee1.setResume(entity.getResume());
            return employeeRepository.save(employee1);
        }
        return null;
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeesByPosition(String position) {
        return employeeRepository.getEmployeesByPosition(position);
    }

    @Override
    public List<Employee> getEmployeeBySalary(Integer salaryMin, Integer salaryMax) {
        return employeeRepository.getEmployeeBySalary(salaryMin, salaryMax);
    }
}
