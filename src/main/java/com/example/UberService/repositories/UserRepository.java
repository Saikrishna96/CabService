package com.example.UberService.repositories;

import com.example.UberService.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class UserRepository {

    private final Map<String, User> users;

    public UserRepository() {
        this.users = new HashMap<>();
    }

    public User save(User user) {
//        user.setId(UUID.randomUUID().toString()); // sending driverid manually for testing purpose
        users.put(user.getId(), user);
        return user;
    }

    public User findById(String userId) {
        return users.get(userId);
    }
}

