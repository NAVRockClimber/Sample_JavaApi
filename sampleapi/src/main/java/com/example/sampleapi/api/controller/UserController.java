package com.example.sampleapi.api.controller;

import java.util.Optional;
import org.springframework.web.bind.annotation.RestController;
import com.example.sampleapi.api.model.User;
import com.example.sampleapi.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value="/user")
    public ResponseEntity<User> getUser(@RequestParam int id){
        Optional<User> optional = userService.getUser(id);
        if (optional.isPresent()) {
            return new ResponseEntity<User>(optional.get(), HttpStatus.OK);
        } 
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }
}

