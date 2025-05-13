package com.ogs.controller;

import com.ogs.model.Student;
import com.ogs.service.AdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/") // Optional base path
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/studentCount")
    public ResponseEntity<Long> getStudentCount() {
        long count = adminService.studentCount();
        return ResponseEntity.ok(count);
    }
   

	     @GetMapping("/viewallstudents")
	        public List<Student> getAllStudents() {
	            return adminService.viewAllStudents();
	        }
}

