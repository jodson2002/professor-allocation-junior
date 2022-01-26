package com.project.professor.allocation.service;


import com.project.professor.allocation.repository.AllocationRepository;
import org.springframework.stereotype.Service;

@Service
public class AllocationService {

    private AllocationRepository allocationRepository;

    public AllocationService(com.project.professor.allocation.repository.AllocationRepository allocationRepository) {
        this.allocationRepository = allocationRepository;
    }
}
