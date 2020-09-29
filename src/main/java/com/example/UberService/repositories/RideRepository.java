package com.example.UberService.repositories;

import com.example.UberService.model.Ride;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class RideRepository {

    private final Map<String, Ride> rides;

    public RideRepository() {
        this.rides = new HashMap<>();
    }

    public Ride save(Ride ride) {
        ride.setId(UUID.randomUUID().toString());
        rides.put(ride.getId(), ride);
        return ride;
    }

    public List<Ride> getRidesByUserId(String userId) {
        return rides.values().stream().filter(ride -> ride.getUserId().equals(userId)).collect(
                Collectors.toList());
    }

    public List<Ride> getRidesByDriverId(String driverId){
        return rides.values().stream().filter(ride -> ride.getDriverId().equals(driverId)).collect(
                Collectors.toList());
    }

    public Ride findById(String id) {
        return rides.get(id);
    }

    public void update(Ride ride) {
        rides.put(ride.getId(), ride);
    }

    public int getTotalRidesCount(){
        return rides.keySet().size();
    }
}