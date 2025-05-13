package com.ogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogs.model.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String> {
    List<Course> findByCourseNameContainingIgnoreCase(String name);
    List<Course> findByDepartmentId(String departmentId);
    List<Course> findByLecturerId(Long lecturerId);
    
}

