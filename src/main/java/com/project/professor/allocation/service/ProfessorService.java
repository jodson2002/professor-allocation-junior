package com.project.professor.allocation.service;



import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Professor create(Professor professor)
    {
        professor.setId(null);
        Professor professorNew = saveInternal(professor);
        return professorNew;
    }

    public Professor update(Professor professor)
    {
        Long id = professor.getId();

        if (id != null && professorRepository.existsById(id))
        {
            Professor professorNew = saveInternal(professor);
            return professorNew;
        }
        else
        {
            return null;
        }
    }

    public void deleteById(Long id)
    {
        if (id != null && professorRepository.existsById(id))
        {
            professorRepository.deleteById(id);
        }
    }

    public void deleteAll()
    {
        professorRepository.deleteAll();
    }
    private Allocation saveInternal(Allocation allocation) {
        if (hasCollision(allocation)) {
            throw new RuntimeException();
        } else {
            allocation = allocationRepository.save(allocation);

            Professor professor = professorService.findById(allocation.getProfessorId());
            allocation.setProfessor(professor);

            Course course = courseService.findById(allocation.getCourseId());
            allocation.setCourse(course);

            return allocation;
        }
    }
    boolean hasCollision(Allocation newAllocation) {
        boolean hasCollision = false;

        List<Allocation> currentAllocations = allocationRepository.findByProfessorId(newAllocation.getProfessorId());

        for (Allocation currentAllocation : currentAllocations) {
            hasCollision = hasCollision(currentAllocation, newAllocation);
            if (hasCollision) {
                break;
            }
        }

        return hasCollision;
    }

    private boolean hasCollision(Allocation currentAllocation, Allocation newAllocation) {
        return !currentAllocation.getId().equals(newAllocation.getId())
                && currentAllocation.getDay() == newAllocation.getDay()
                && currentAllocation.getStart().compareTo(newAllocation.getEnd()) < 0
                && newAllocation.getStart().compareTo(currentAllocation.getEnd()) < 0;
    }
}

