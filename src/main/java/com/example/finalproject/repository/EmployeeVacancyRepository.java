package com.example.finalproject.repository;

import com.example.finalproject.models.EmployeeVacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeVacancyRepository extends JpaRepository<EmployeeVacancy, Long> {
}
