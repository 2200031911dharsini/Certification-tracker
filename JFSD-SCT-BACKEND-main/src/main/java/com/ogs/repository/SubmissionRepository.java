package com.ogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogs.model.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, Long>{

}
