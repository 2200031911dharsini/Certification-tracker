package com.ogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogs.model.Course_Enrollment;

public interface Course_EnrollmentRepository extends JpaRepository<Course_Enrollment, Long> {

}
