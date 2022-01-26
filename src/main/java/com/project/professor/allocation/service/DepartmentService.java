package com.project.professor.allocation.service;


import com.project.professor.allocation.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(com.project.professor.allocation.repository.DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

}
