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
@Table(name = "test")
public class Test implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @CheckString
    private String name;

    @OneToMany(mappedBy = "testId")
    private List<Question> questions;
    @OneToMany(mappedBy = "testId")
    private List<Vacancy> vacancies;

    public Test(String s) {
        this.name = s;
    }

    public Test(Long id, String s) {
        this.id = id;
        this.name = s;
    }
}

