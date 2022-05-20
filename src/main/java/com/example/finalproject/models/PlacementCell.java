package com.example.finalproject.models;

import com.example.finalproject.validator.CheckString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "placement_cell")
public class PlacementCell implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @CheckString
    private String name;
    @OneToMany(mappedBy = "placementCellId")
    private List<Vacancy> vacancies;
}
