package com.example.UberService.services;

import com.example.UberService.model.Cab;
import com.example.UberService.repositories.CabRepository;
import org.springframework.stereotype.Service;

@Service
public class CabService {
    private final CabRepository cabRepository;

    public CabService(CabRepository cabRepository) {
        this.cabRepository = cabRepository;
    }

    public Cab register(Cab cab) {
        return cabRepository.save(cab);
    }
}