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
@Table(name = "USERS")
@Entity
public class User implements Serializable{
    
    @Id
    @Column(name = "ID_QUESTION")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORLD")
    private String passworld;

    @Column(name = "CORRECT_ANSWERS")
    private Integer corrects;
    
    @Column(name = "INCORRECT_ANSWERS")
    private Integer incorrects;
}
