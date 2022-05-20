package com.example.finalproject.models;

import com.example.finalproject.validator.CheckSalary;
import com.example.finalproject.validator.CheckString;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "vacancy")
public class Vacancy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @CheckString
    private String name;
    @Column(name = "address")
    @CheckString
    private String address;
    @Column(name = "position")
    @CheckString
    private String position;
    @Column(name = "description")
    @CheckString
    private String description;
    @Column(name = "salary_min")
    @CheckSalary
    private Integer salaryMin;
    @Column(name = "salary_max")
    @CheckSalary
    private Integer salaryMax;
    @OneToMany(mappedBy = "vacancyId")
    private List<EmployeeVacancy> employeeVacancies;
    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Test testId;
    @ManyToOne
    @JoinColumn(name = "placement_cell_id", referencedColumnName = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private PlacementCell placementCellId;

}
