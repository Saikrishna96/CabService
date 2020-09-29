package com.example.UberService.controllers;

import com.example.UberService.model.Ride;
import com.example.UberService.services.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/book")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping(path = "/user/{userId}")
    public String book(@PathVariable("userId") String userId, @RequestParam("x") int x,
                       @RequestParam("y") int y) {
        return bookingService.book(userId, x, y).toString();
    }

    @GetMapping(path = "/driver/{driverId}/endride")
    public Ride endRide(@PathVariable("driverId") String driverId,
                        @RequestParam("rideId") String rideId, @RequestParam("x") int x,
                        @RequestParam("y") int y) {
        return bookingService.endRide(driverId, rideId, x, y);
    }

    @GetMapping(path = "/total-rides")
    public int getTotalRides() {
        return bookingService.getTotalRides();
    }
}