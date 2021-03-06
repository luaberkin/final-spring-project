package com.example.finalproject.repository;

import com.example.finalproject.models.Role;
import com.example.finalproject.service.IRoleService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
