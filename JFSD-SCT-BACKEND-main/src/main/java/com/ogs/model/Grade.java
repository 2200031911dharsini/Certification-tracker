package com.ogs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "grade_table")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id", nullable = false, unique = true)
    private Long gradeId;

    @Column(name = "student_id", nullable = false)
    @NotBlank(message = "Student ID cannot be blank.")
    private String studentId;

    @Column(name = "assignment_id", nullable = false)
    @NotBlank(message = "Assignment ID cannot be blank.")
    private String assignmentId;

    @Column(name = "grade_value", nullable = false)
    @NotBlank(message = "Grade value cannot be blank.")
    private String gradeValue; // Numeric or letter grade

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "grade_date", nullable = false)
    private LocalDate gradeDate;

    // Getters and Setters
    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
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

    public String getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(String gradeValue) {
        this.gradeValue = gradeValue;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public LocalDate getGradeDate() {
        return gradeDate;
    }

    public void setGradeDate(LocalDate gradeDate) {
        this.gradeDate = gradeDate;
    }
}
