package com.ogs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "student_table")
public class Student {

    @Id
    @Column(name = "student_id", nullable = false, unique = true)
    @Min(value = 1000000000L, message = "Student ID must be a 10-digit number.")
    @Max(value = 9999999999L, message = "Student ID must be a 10-digit number.")
    private long studentId;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password cannot be blank.")
    private String password;

    @Column(name = "student_name", nullable = false)
    @NotBlank(message = "Student name cannot be blank.")
    private String studentName;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Email should be valid.")
    private String email;

    @Column(name = "dept_id", nullable = false)
    @Pattern(regexp = "^[A-Za-z]{2,}$", message = "Department ID must be a valid string like CSE, ECE, BBA.")
    private String deptId;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "contact")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must be 10 digits.")
    private String contact;

    @ManyToMany
    @JoinTable(
        name = "student_courses",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    // Getters and Setters
    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
