package com.project.professor.allocation.service;


import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    public CourseService(com.project.professor.allocation.repository.CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course findById(Long Id){

        Optional<Course> courseOptional = courseRepository.findById(Id);
        Course course = courseOptional.orElse(null);
        return course;

    }

}
