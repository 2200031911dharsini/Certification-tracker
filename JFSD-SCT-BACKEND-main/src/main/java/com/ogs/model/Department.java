package com.ogs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "department_table")
public class Department {

    @Id
    @Column(name = "department_id", nullable = false, unique = true)
    private Long departmentId;

    @Column(name = "department_name", nullable = false, unique = true)
    @NotBlank(message = "Department name cannot be blank.")
    private String departmentName;

    @Column(name = "department_head_id", nullable = false)
    @NotBlank(message = "Department head ID cannot be blank.")
    private String departmentHeadId;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "location")
    private String location;

    // Getters and Setters
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentHeadId() {
        return departmentHeadId;
    }

    public void setDepartmentHeadId(String departmentHeadId) {
        this.departmentHeadId = departmentHeadId;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
