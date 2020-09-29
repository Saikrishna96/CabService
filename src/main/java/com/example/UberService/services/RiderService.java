package com.example.UberService.services;

import com.example.UberService.model.Location;
import com.example.UberService.model.Ride;
import com.example.UberService.repositories.RideRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderService {
    private final RideRepository rideRepository;

    public RiderService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public Ride createRide(String userId, String driverId, Location startLocation) {
        Ride ride = new Ride(userId, driverId, startLocation);
        rideRepository.save(ride);
        return ride;
    }

    public Ride getRide(String rideId) {
        return rideRepository.findById(rideId);
    }

    public void update(Ride ride) {
        rideRepository.update(ride);
    }

    public List<Ride> getuserRides(String userId) {
        return rideRepository.getRidesByUserId(userId);
    }

    public List<Ride> getDriverRides(String driverId) {
        return rideRepository.getRidesByDriverId(driverId);
    }

    public int getTotalRideCount(){
        return rideRepository.getTotalRidesCount();
    }

}