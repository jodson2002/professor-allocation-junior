package com.project.professor.allocation.service;


import com.project.professor.allocation.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    private ProfessorRepository professorRepository;

    public ProfessorService(com.project.professor.allocation.repository.ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

}
