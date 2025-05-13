package com.ogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogs.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

}
