package com.world.questions.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "QUESTIONS")
@Entity
public class Question implements Serializable{

    @Id
    @Column(name = "ID_QUESTION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TEXT_QUESTION")
    private String question;

    @Column(name = "NU_ANSWER")
    private int answer;

    @Column(name = "RIGHT_ANSWER")
    private Integer right;

    @Column(name = "WRONG_ANSWER")
    private Integer wrong;

    @Column(name = "OPTION_A")
    private String optionA;

    @Column(name = "OPTION_B")
    private String optionB;
    
    @Column(name = "OPTION_C")
    private String optionC;

    @Column(name = "OPTION_D")
    private String optionD;

    @Column(name = "OPTION_E")
    private String optionE;
}
