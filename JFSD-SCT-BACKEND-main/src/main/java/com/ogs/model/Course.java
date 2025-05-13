package com.ogs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "course_table")
public class Course {

    @Id
    @Column(name = "course_id", nullable = false, unique = true)
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Course ID must contain only numbers and letters.")
    private String courseId;

    @Column(name = "course_name", nullable = false)
    @NotBlank(message = "Course name cannot be blank.")
    private String courseName;

    @Column(name = "course_description", nullable = true)
    private String courseDescription;

    @Column(name = "lecturer_id")
    private Long lecturerId; // Can be assigned later, optional during initial creation

    @Column(name = "department_id", nullable = false)
    @NotBlank(message = "Department ID cannot be blank.")
    @Pattern(regexp = "^[A-Za-z]{3,}$", message = "Department ID must be a valid string like CSE, ECE, BBA.")
    private String departmentId;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    // Getters and Setters
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Long getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Long lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
