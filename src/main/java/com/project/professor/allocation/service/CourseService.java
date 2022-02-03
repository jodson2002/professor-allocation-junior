package com.project.professor.allocation.service;


import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    private CourseRepository courseRepository;


    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course findById(Long id)
    {
        Optional<Course> CourseOptional = courseRepository.findById(id);
        Course Course = CourseOptional.orElse(null);
        return Course;
    }
    public Course create(Course course)
    {
        Course.setId(null);
        Course curseNew = saveInternal(course);
        return courseNew;
    }

    public Course update(Course course)
    {
        Long id = course.getId();

        if (id != null && courseRepository.existsById(id))
        {
            Course curseNew = saveInternal(course);
            return curseNew;
        }
        else
        {
            return null;
        }
    }

    public void deleteById(Long id)
    {
        if (id != null && courseRepository.existsById(id))
        {
            courseRepository.deleteById(id);
        }
    }

    public void deleteAll()
    {
        courseRepository.deleteAll();
    }
}