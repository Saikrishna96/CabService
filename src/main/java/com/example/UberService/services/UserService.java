package com.example.UberService.services;

import com.example.UberService.model.Ride;
import com.example.UberService.model.User;
import com.example.UberService.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RiderService riderService;

    public UserService(UserRepository userRepository,
                       RiderService riderService) {
        this.userRepository = userRepository;
        this.riderService = riderService;
    }

    public User register(User user) {
        return userRepository.save(user);
    }

    public User getUser(String userId) {
        return userRepository.findById(userId);
    }

    public List<Ride> getAllRides(String userId) {
        return riderService.getuserRides(userId);
    }
}
