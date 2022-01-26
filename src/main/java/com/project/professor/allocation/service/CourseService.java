package com.project.professor.allocation.service;


import com.project.professor.allocation.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    public CourseService(com.project.professor.allocation.repository.CourseRepository courseRepository) {
        courseRepository = courseRepository;
    }

}
