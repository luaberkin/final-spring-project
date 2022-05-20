package com.example.finalproject.service;

import com.example.finalproject.models.EmployeeRole;

import java.util.List;
import java.util.Optional;

public interface IEmployeeRoleService {

    Optional<EmployeeRole> findOne(Long id);

    List<EmployeeRole> findAll();

    EmployeeRole save(EmployeeRole entity);

    EmployeeRole update(Long id, EmployeeRole entity);

    void deleteAll();

    void deleteById(Long id);
}
