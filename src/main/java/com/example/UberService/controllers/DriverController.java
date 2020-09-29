package com.example.UberService.controllers;

import com.example.UberService.model.Driver;
import com.example.UberService.model.DriverStatus;
import com.example.UberService.model.Ride;
import com.example.UberService.services.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/driver")
public class DriverController {
    private  final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public Driver create(@RequestBody Driver driver) {
        return driverService.register(driver);
    }

    @PutMapping(path = "/{driverId}")
    public Driver update(@PathVariable("driverId") String driverId,
                         @RequestParam("x") int x, @RequestParam("y") int y, @RequestParam("status")
            DriverStatus driverStatus) {
        return driverService.update(driverId, x, y, driverStatus);
    }

    @GetMapping(path = "/{driverId}")
    public Driver get(@PathVariable("driverId") String driverId) {
        return driverService.getDriver(driverId);
    }

    @GetMapping(path = "{driverId}/rides")
    public List<Ride> getRides(@PathVariable("driverId") String driverId) {
        return driverService.getAllRides(driverId);
    }
}