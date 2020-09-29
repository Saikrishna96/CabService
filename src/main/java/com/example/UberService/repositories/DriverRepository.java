package com.example.UberService.repositories;

import com.example.UberService.HelperUtils.DistanceCalculator;
import com.example.UberService.model.Driver;
import com.example.UberService.model.DriverStatus;
import com.example.UberService.model.Location;
import com.example.UberService.model.Ride;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class DriverRepository {

    private final Map<String, Driver> drivers;
    //  @Value ("$config.maxdistance")
    private final int MAX_DISTANCE = 25;

    public DriverRepository() {
        this.drivers = new HashMap<>();
    }

    public Driver save(Driver driver) {
//        driver.setId(UUID.randomUUID().toString()); // sending driverid manually for testing purpose
        drivers.put(driver.getId(), driver);
        return driver;
    }

    public Driver findById(String driverId) {
        return drivers.get(driverId);
    }


    public void update(Driver driver) {
        drivers.put(driver.getId(), driver);
    }

    public List<Driver> findAvailableDriver(Location location) {
        return drivers.values().stream().filter(driver -> driver.getStatus().equals(DriverStatus.AVAILABLE))
                .filter(driver ->
                        DistanceCalculator.calculateDistance(location, driver.getLocation()) < MAX_DISTANCE).collect(
                        Collectors.toList());
    }

}