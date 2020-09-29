package com.example.UberService.controllers;

import com.example.UberService.model.Cab;
import com.example.UberService.services.CabService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cab")
public class CabController {

    private final CabService cabService;

    public CabController(CabService cabService) {
        this.cabService = cabService;
    }

    @PostMapping
    public Cab create(@RequestBody Cab cab) {
        return cabService.register(cab);
    }
}
