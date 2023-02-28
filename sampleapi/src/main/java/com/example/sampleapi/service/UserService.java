package com.example.sampleapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.stereotype.Service;

import java.util.List;

import com.example.sampleapi.api.model.User;

@Service
public class UserService {
    
    private List<User> userList;

    public UserService() {
        this.userList = new ArrayList<User>();

        User user1 = new User(1, "Ida", "ida@example.com", 40);
        User user2 = new User(2, "Hans", "Hans@example.com", 25);
        User user3 = new User(3, "Lars", "Lars@example.com", 30);
        User user4 = new User(4, "Eva", "Eva@example.com", 42);

        userList.addAll(Arrays.asList(user1, user2, user3, user4));
    }

    public Optional<User> getUser(int id) {
        Optional<User> optional = Optional.empty();
        for (User user: userList) {
            if (id == user.getId()) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}
