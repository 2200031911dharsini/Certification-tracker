package com.ogs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "lecturer_table")
public class Lecturer {

    @Id
    @Column(name = "lecturer_user_id", nullable = false, unique = true)
    @Min(value = 1000, message = "User ID must be a 4-digit number.")
    @Max(value = 9999, message = "User ID must be a 4-digit number.")
    private int lecturerUserId;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password cannot be blank.")
    private String password;

    @Column(name = "lecturer_name", nullable = false)
    @NotBlank(message = "Lecturer name cannot be blank.")
    private String lecturerName;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Email should be valid.")
    private String email;

    @Column(name = "dept_id", nullable = false)
    @Pattern(regexp = "^[A-Za-z]{3,}$", message = "Department ID must be a valid string like CSE, ECE, BBA.")
    private String deptId;

    @Column(name = "contact")
    private String contact;

    // Getters and Setters
    public int getLecturerUserId() {
        return lecturerUserId;
    }

    public void setLecturerUserId(int lecturerUserId) {
        this.lecturerUserId = lecturerUserId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
