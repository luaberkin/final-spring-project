package com.example.finalproject.repository;

import com.example.finalproject.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> getEmployeesByPosition(String position);

    @Query("select e from Employee e " +
            "where e.salary between :salaryMin and :salaryMax")
    List<Employee> getEmployeeBySalary(@Param("salaryMin") Integer salaryMin, @Param("salaryMax") Integer salaryMax);
}
