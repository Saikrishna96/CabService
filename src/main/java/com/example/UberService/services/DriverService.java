package com.example.UberService.services;

import com.example.UberService.model.Driver;
import com.example.UberService.model.DriverStatus;
import com.example.UberService.model.Location;
import com.example.UberService.model.Ride;
import com.example.UberService.repositories.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DriverService {
    private final DriverRepository driverRepository;
    private final RiderService riderService;

    public DriverService(DriverRepository driverRepository, RiderService riderService) {
        this.driverRepository = driverRepository;
        this.riderService = riderService;
    }

    public Driver register(Driver driver) {
        driver.setStatus(DriverStatus.AVAILABLE);
        return driverRepository.save(driver);
    }

    public Driver update(String driverId, int x, int y, DriverStatus driverStatus) {
        Driver driver = driverRepository.findById(driverId);
        driver.setLocation(new Location(x,y));
        if(Objects.nonNull(driverStatus)) {
            driver.setStatus(driverStatus);
        }
        driverRepository.update(driver);
        return driver;
    }

    public Driver updateStatus(String driverId, DriverStatus driverStatus) {
        Driver driver = driverRepository.findById(driverId);
        if(Objects.nonNull(driverStatus)) {
            driver.setStatus(driverStatus);
        }
        driverRepository.update(driver);
        return driver;
    }

    public List<Driver> findNearBuyDriver(Location location) {
        return driverRepository.findAvailableDriver(location);
    }

    public List<Ride> getAllRides(String driverId){
        return riderService.getDriverRides(driverId);
    }

    public Driver getDriver(String driverId) {
        return driverRepository.findById(driverId);
    }

    public Driver endRide(Driver driver, Location endLocation) {
        driver.setStatus(DriverStatus.AVAILABLE);
        driver.setLocation(endLocation);
        driverRepository.update(driver);
        return driver;
    }
}