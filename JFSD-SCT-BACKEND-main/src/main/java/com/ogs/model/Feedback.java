package com.ogs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "feedback_table")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id", nullable = false, unique = true)
    private Long feedbackId;

    @Column(name = "submission_id", nullable = false)
    @NotBlank(message = "Submission ID cannot be blank.")
    private String submissionId;

    @Column(name = "lecturer_id", nullable = false)
    @NotBlank(message = "Lecturer ID cannot be blank.")
    private String lecturerId;

    @Column(name = "feedback_text", nullable = false)
    @NotBlank(message = "Feedback text cannot be blank.")
    private String feedbackText;

    @Column(name = "feedback_date", nullable = false)
    private LocalDate feedbackDate;

    // Getters and Setters
    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public LocalDate getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(LocalDate feedbackDate) {
        this.feedbackDate = feedbackDate;
    }
}
