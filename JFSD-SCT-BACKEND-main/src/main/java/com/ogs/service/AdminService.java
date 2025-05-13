package com.ogs.service;

import java.util.List;
import com.ogs.model.Admin;
import com.ogs.model.Student;
import com.ogs.model.Lecturer;
import com.ogs.model.Course;

public interface AdminService {

    // Student Management
    public List<Student> viewAllStudents();
    public boolean addStudent(Student student);
    public boolean deleteStudent(Long studentId); // Changed parameter type to Long
    public boolean updateStudent(Student student);
    public boolean resetStudentPassword(Long studentId, String newPassword); // Changed parameter type to Long
    public List<Student> searchStudentsByCourse(String courseName);
    public List<Student> searchStudentsByName(String name);
    public List<Student> filterStudentsByDepartmentId(Long departmentId); // Changed parameter type to Long
    public List<Student> filterStudentsBySpecialization(String specialization);
    public List<Course> viewEnrolledCoursesByStudent(Long studentId); // Changed parameter type to Long
    public long studentCount();

    // Lecturer Management
    public List<Lecturer> viewAllLecturers();
    public boolean addLecturer(Lecturer lecturer);
    public boolean deleteLecturer(Integer lecturerId); // Changed parameter type to Long
    public boolean updateLecturer(Lecturer lecturer);
    public List<Lecturer> searchLecturersByName(String name);
    public List<Lecturer> filterLecturersByDepartmentId(Long departmentId); // Changed parameter type to Long
    public List<Course> viewCoursesByLecturer(Long lecturerId); // Changed parameter type to Long
    public long lecturerCount();

    // Course Management
    public List<Course> viewAllCourses();
    public boolean addCourse(Course course);
    public boolean deleteCourse(String courseId); // Changed parameter type to Long
    public boolean updateCourse(Course course);
    public List<Course> searchCoursesByName(String name);
    public List<Course> filterCoursesByDepartmentId(Long departmentId); // Changed parameter type to Long
    public long courseCount();

    // Assigning Courses to Students
    public boolean assignCourseToStudent(String courseId, Long studentId); // Changed parameter type to Long
    public boolean updateStudentCourseEnrollment(Long studentId, List<String> courseIds); // Changed parameter type to Long
    public List<Student> viewStudentsByCourse(String courseId); // Changed parameter type to Long
    
    
    public Admin checkAdminLogin(String uname, String pwd);
}
