package com.project.professor.allocation.service;


import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(com.project.professor.allocation.repository.DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department findById(Long Id){

        Optional<Department> departmentOptional = departmentRepository.findById(Id);
        Department department = departmentOptional.orElse(null);
        return department;
    }
}
