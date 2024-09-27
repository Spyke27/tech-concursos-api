package com.world.questions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.world.questions.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
    
}
