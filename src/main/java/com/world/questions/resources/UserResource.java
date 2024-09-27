package com.world.questions.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.world.questions.dto.UserDTO;
import com.world.questions.entities.User;
import com.world.questions.services.UserService;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "*")
public class UserResource {
    
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {

        return ResponseEntity.ok().body(service.findAllUsers());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO user) {
        service.createUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
