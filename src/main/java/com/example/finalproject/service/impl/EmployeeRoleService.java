package com.example.finalproject.service.impl;

import com.example.finalproject.models.EmployeeRole;
import com.example.finalproject.repository.EmployeeRoleRepository;
import com.example.finalproject.service.IEmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeRoleService implements IEmployeeRoleService{

    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;

    @Override
    public Optional<EmployeeRole> findOne(Long id) {
        return employeeRoleRepository.findById(id);
    }

    @Override
    public List<EmployeeRole> findAll() {
        return employeeRoleRepository.findAll();
    }

    @Override
    public EmployeeRole save(EmployeeRole employeeRole) {
        return employeeRoleRepository.save(employeeRole);
    }

    @Override
    public EmployeeRole update(Long id, EmployeeRole entity) {
        Optional<EmployeeRole> employeeRole = employeeRoleRepository.findById(id);
        if(employeeRole.isPresent()){
            EmployeeRole employeeRole1 = employeeRole.get();
            employeeRole1.setEmployeeId(entity.getEmployeeId());
            employeeRole1.setRoleId(entity.getRoleId());
            return employeeRoleRepository.save(employeeRole1);
        }
        return null;
    }

    @Override
    public void deleteAll() {
        employeeRoleRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        employeeRoleRepository.deleteById(id);
    }
}
