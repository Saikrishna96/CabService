package com.example.UberService.model;

import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private String email;
    private Location location;

}
