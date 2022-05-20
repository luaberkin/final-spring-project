package com.example.finalproject.service.impl;

import com.example.finalproject.models.Role;
import com.example.finalproject.repository.RoleRepository;
import com.example.finalproject.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public Optional<Role> findOne(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Long id, Role entity) {
        Optional<Role> role = roleRepository.findById(id);
        if(role.isPresent()){
            Role role1 = role.get();
            role1.setName(entity.getName());
            role1.setEmployeeRoles(entity.getEmployeeRoles());
            return roleRepository.save(role1);
        }
        return null;
    }

    @Override
    public void deleteAll() {
        roleRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}
