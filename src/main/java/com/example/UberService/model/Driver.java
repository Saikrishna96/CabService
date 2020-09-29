package com.example.UberService.model;

import lombok.Data;

@Data
public class Driver {
    private String id;
    private String name;
    private String phoneNumber;
    private String cabId;
    private DriverStatus status;
    private Location location;
}
