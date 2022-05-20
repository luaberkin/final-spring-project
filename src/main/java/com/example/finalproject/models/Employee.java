package com.example.finalproject.models;

import com.example.finalproject.validator.CheckSalary;
import com.example.finalproject.validator.CheckString;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @CheckString
    private String name;
    @Column(name = "position")
    @CheckString
    private String position;
    @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(name = "resume", nullable = false)
    private byte[] resume;
    @Column(name = "salary")
    @CheckSalary
    private Integer salary;

    @OneToMany(mappedBy = "employeeId")
    private List<EmployeeVacancy> employeeVacancies;
    @OneToMany(mappedBy = "employeeId")
    private List<EmployeeRole> employeeRoles;

}
