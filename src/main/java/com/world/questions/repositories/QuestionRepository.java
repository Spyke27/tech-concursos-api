package com.world.questions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.world.questions.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
    
}
