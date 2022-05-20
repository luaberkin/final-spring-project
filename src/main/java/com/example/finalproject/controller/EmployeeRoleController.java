package com.example.finalproject.controller;

import com.example.finalproject.models.EmployeeRole;
import com.example.finalproject.service.impl.EmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employee-role")
public class EmployeeRoleController {

    @Autowired
    private EmployeeRoleService employeeRoleService;

    @GetMapping
    public ResponseEntity<List<EmployeeRole>> findAll(){
        List<EmployeeRole> employeeRoleList = employeeRoleService.findAll();
        if(employeeRoleList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else{
            return new ResponseEntity<>(employeeRoleList, HttpStatus.OK);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeRole> findById(@PathVariable("id") Long id){
        Optional<EmployeeRole> employeeRole = employeeRoleService.findOne(id);
        if(employeeRole.isPresent()){
            return new ResponseEntity<>(employeeRole.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<EmployeeRole> save(@RequestBody EmployeeRole employeeRole){
        try{
            employeeRoleService.save(employeeRole);
            return new ResponseEntity<>(employeeRole, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeRole> update(@PathVariable("id") Long id, @RequestBody EmployeeRole employeeRole){
        try{
            EmployeeRole updated = employeeRoleService.update(id, employeeRole);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id){
        try{
            employeeRoleService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAll(){
        try{
            employeeRoleService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
