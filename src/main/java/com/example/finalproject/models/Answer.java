package com.example.finalproject.models;

import com.example.finalproject.validator.CheckString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "answer")
public class Answer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "text")
    @CheckString
    private String text;
    @Column(name = "score")
    private Integer score;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question questionId;
}
