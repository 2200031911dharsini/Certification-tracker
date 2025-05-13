package com.ogs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "assignment_table")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID
    @Column(name = "assignment_id", nullable = false, unique = true)
    private long assignmentId;

    @Column(name = "course_id", nullable = false)
    @NotBlank(message = "Course ID cannot be blank.")
    private String courseId;

    @Column(name = "title", nullable = false)
    @NotBlank(message = "Title cannot be blank.")
    private String title;

    @Column(name = "description", nullable = false)
    @NotBlank(message = "Description cannot be blank.")
    private String description;

    @Column(name = "due_date", nullable = false)
    @Future(message = "Due date must be in the future.")
    private LocalDateTime dueDate;

    @Column(name = "total_marks", nullable = false)
    @Min(value = 1, message = "Total marks must be a positive number.")
    private int totalMarks;

    @Column(name = "file_required", nullable = false)
    private boolean fileRequired;

    @Column(name = "created_by", nullable = false)
    @NotBlank(message = "Created by (Lecturer ID) cannot be blank.")
    private String createdBy;

    @Column(name = "created_time", nullable = false, updatable = false)
    private LocalDateTime createdTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDate createdDate;

    // Getters and Setters
    public long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public boolean isFileRequired() {
        return fileRequired;
    }

    public void setFileRequired(boolean fileRequired) {
        this.fileRequired = fileRequired;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
