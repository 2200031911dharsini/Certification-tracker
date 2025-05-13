package com.ogs.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ogs.model.Lecturer;

import java.util.List;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {
    List<Lecturer> findByLecturerNameContainingIgnoreCase(String name);
    List<Lecturer> findByDeptId(String departmentId);
}
