package com.example.finalproject.controller;

import com.example.finalproject.models.Role;
import com.example.finalproject.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> findAll(){
        List<Role> roleList = roleService.findAll();
        if(roleList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else{
            return new ResponseEntity<>(roleList, HttpStatus.OK);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Role> findById(@PathVariable("id") Long id){
        Optional<Role> role = roleService.findOne(id);
        if(role.isPresent()){
            return new ResponseEntity<>(role.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Role> save(@RequestBody Role role){
        try{
            roleService.save(role);
            return new ResponseEntity<>(role, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> update(@PathVariable("id") Long id, @RequestBody Role role){
        try{
            Role updated = roleService.update(id, role);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id){
        try{
            roleService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAll(){
        try{
            roleService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
