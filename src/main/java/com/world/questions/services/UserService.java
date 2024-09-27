package com.world.questions.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.world.questions.dto.UserDTO;
import com.world.questions.entities.User;
import com.world.questions.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public void createUser(@RequestBody UserDTO obj) {
        User user = new User();

        user.setNickname(obj.nickname());
        user.setEmail(obj.email());
        user.setPassworld(obj.passworld());
        user.setCorrects(0);
        user.setIncorrects(0);

        repository.save(user);
    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }
}
