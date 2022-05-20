package com.example.finalproject.repository;

import com.example.finalproject.models.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

    List<Vacancy> getVacancyByPosition(String position);

    @Query("select v from Vacancy v " +
            " where v.salaryMin >= :salaryMin and v.salaryMax <= :salaryMax")
    List<Vacancy> getBetweenSalaryMinAndMax(@Param("salaryMin") Integer salaryMin, @Param("salaryMax") Integer salaryMax);
}
