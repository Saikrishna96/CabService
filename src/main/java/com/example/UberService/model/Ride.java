package com.example.UberService.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Ride {
    private String id;
    private String userId;
    private String driverId;
    private Location startLocation;
    private Location endLocation;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private RideStatus status;

    public Ride(String userId, String driverId, Location startLocation) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.driverId = driverId;
        this.startLocation = startLocation;
        this.startTime = LocalDateTime.now();
        this.status = RideStatus.STARTED;
    }
}
