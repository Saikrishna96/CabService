package com.example.UberService.repositories;

import com.example.UberService.model.Cab;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class CabRepository {

    private final Map<String, Cab> cabs;

    public CabRepository() {
        this.cabs = new HashMap<>();
    }

    public Cab save(Cab cab) {
//        cab.setId(UUID.randomUUID().toString()); // sending cabId manually for testing purpose
        cabs.put(cab.getId(), cab);
        return cab;
    }
}
