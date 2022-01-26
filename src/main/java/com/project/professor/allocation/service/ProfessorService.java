package com.project.professor.allocation.service;


import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {

    private ProfessorRepository professorRepository;

    public ProfessorService(com.project.professor.allocation.repository.ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor findById(Long Id){

        Optional<Professor> professorOptional = professorRepository.findById(Id);
        Professor professor = professorOptional.orElse(null);
        return professor;

    }

}
