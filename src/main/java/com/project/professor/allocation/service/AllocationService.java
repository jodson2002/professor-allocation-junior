package com.project.professor.allocation.service;


import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.repository.AllocationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AllocationService {

    private AllocationRepository allocationRepository;

    public AllocationService(com.project.professor.allocation.repository.AllocationRepository allocationRepository) {
        this.allocationRepository = allocationRepository;
    }

    public Allocation findById(Long Id){

        Optional<Allocation> allocationOptional = allocationRepository.findById(Id);
        Allocation allocation = allocationOptional.orElse(null);
        return allocation;

    }

}
