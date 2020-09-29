package com.example.UberService.services;

import com.example.UberService.model.*;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class BookingService {

    private final UserService userService;
    private final DriverService driverService;
    private final RiderService riderService;

    public BookingService(UserService userService,
                          DriverService driverService, RiderService riderService) {
        this.userService = userService;
        this.driverService = driverService;
        this.riderService = riderService;
    }

    public JSONObject book(String userId, int x, int y) {
        User user = userService.getUser(userId);
        if (Objects.isNull(user)) {
            throw new RuntimeException("User not present");
        }
        Location searchLocation = new Location(x, y);
        List<Driver> drivers = driverService.findNearBuyDriver(searchLocation);
        if (drivers == null || drivers.size() == 0) {
            log.info("No drivers near buy");
            JSONObject result = new JSONObject();
            result.put("msg", "No drivers near buy");
            return result;
        }
        Driver driver = drivers.get(0);
        if (Objects.isNull(driver)) {
            throw new RuntimeException("Drivers Not available");
        }

        driverService.updateStatus(driver.getId(), DriverStatus.ON_RIDE);

        Ride ride = riderService.createRide(userId, driver.getId(), searchLocation);
        JSONObject result = new JSONObject();
        result.put("user", user.toString());
        result.put("driver", driver.toString());
        result.put("ride", ride.toString());
        return result;
    }

    public Ride endRide(String driverId, String rideId, int x, int y) {
        Driver driver = driverService.getDriver(driverId);
        if (Objects.isNull(driver))
            throw new RuntimeException("Driver not present");
        System.out.println(driver.getStatus());
        if (!driver.getStatus().equals(DriverStatus.ON_RIDE))
            throw new RuntimeException("No booking present");

        Location endLocation = new Location(x, y);
        driverService.endRide(driver, endLocation);

        Ride ride = riderService.getRide(rideId);

        ride.setStatus(RideStatus.COMPLETED);
        ride.setEndLocation(endLocation);
        ride.setEndTime(LocalDateTime.now());
        //call pricing service
        riderService.update(ride);
        return ride;
    }

    public int getTotalRides(){
        return riderService.getTotalRideCount();
    }
}