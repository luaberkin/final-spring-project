package com.example.finalproject.service;

import com.example.finalproject.models.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {

    Optional<Role> findOne(Long id);

    List<Role> findAll();

    Role save(Role role);
    Role update(Long id, Role entity);

    void deleteAll();

    void deleteById(Long id);
}
