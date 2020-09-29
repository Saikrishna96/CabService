package com.example.UberService.controllers;

import com.example.UberService.model.Ride;
import com.example.UberService.model.User;
import com.example.UberService.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping(path = "{userId}/rides")
    public List<Ride> getRides(@PathVariable("userId") String userId) {
        return userService.getAllRides(userId);
    }
}
