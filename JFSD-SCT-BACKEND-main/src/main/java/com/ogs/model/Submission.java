package com.ogs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "submission_table")
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "submission_id", nullable = false, unique = true)
    private Long submissionId;

    @Column(name = "student_id", nullable = false)
    @NotBlank(message = "Student ID cannot be blank.")
    private String studentId;

    @Column(name = "assignment_id", nullable = false)
    @NotBlank(message = "Assignment ID cannot be blank.")
    private String assignmentId;

    @Column(name = "submission_date", nullable = false)
    private LocalDateTime submissionDate;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "status", nullable = false)
    @NotBlank(message = "Status cannot be blank.")
    private String status; // e.g., "pending", "graded", "late"

    @Column(name = "comments")
    private String comments;

    @Column(name = "submitted_on_time", nullable = false)
    private Boolean submittedOnTime;

    // Getters and Setters
    public Long getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Long submissionId) {
        this.submissionId = submissionId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getSubmittedOnTime() {
        return submittedOnTime;
    }

    public void setSubmittedOnTime(Boolean submittedOnTime) {
        this.submittedOnTime = submittedOnTime;
    }
}
