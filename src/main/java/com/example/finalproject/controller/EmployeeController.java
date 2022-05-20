package com.example.finalproject.controller;


import com.example.finalproject.models.Employee;
import com.example.finalproject.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> employeeList = employeeService.findAll();
        if(employeeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else{
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") Long id){
        Optional<Employee> employee = employeeService.findOne(id);
        if(employee.isPresent()){
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/position")
    public ResponseEntity<List<Employee>> getEmployeeByPosition(@RequestBody String position){
        List<Employee> employeeList = employeeService.getEmployeesByPosition(position);
        if(!employeeList.isEmpty()){
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/bySalary")
    public ResponseEntity<List<Employee>> getEmployeeBySalary(@RequestParam(value = "salaryMin") Integer salaryMin,
                                                              @RequestParam(value = "salaryMax") Integer salaryMax){
        List<Employee> employies = employeeService.getEmployeeBySalary(salaryMin, salaryMax);
        if(employies.isEmpty()){
            return new ResponseEntity<>(employies, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        try{
            employeeService.save(employee);
            return new ResponseEntity<>(employee, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") Long id, @RequestBody Employee employee){
        try{
            Employee updated = employeeService.update(id, employee);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id){
        try{
            employeeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAll(){
        try{
            employeeService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
