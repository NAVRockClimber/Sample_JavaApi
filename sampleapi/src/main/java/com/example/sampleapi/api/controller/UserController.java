package com.example.sampleapi.api.controller;

import java.util.Optional;
import org.springframework.web.bind.annotation.RestController;
import com.example.sampleapi.api.model.User;
import com.example.sampleapi.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;


@RestController
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value="/user")
    public User getUser(@RequestParam int id){
        Optional<User> optional = userService.getUser(id);
        if (optional.isPresent()) {
            return optional.get();
        } 
        throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, "entity not found"
        );
    }
}
