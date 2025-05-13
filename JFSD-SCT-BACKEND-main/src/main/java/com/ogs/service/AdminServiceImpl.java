package com.ogs.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ogs.model.Admin;
import com.ogs.model.Course;
import com.ogs.model.Lecturer;
import com.ogs.model.Student;
import com.ogs.repository.CourseRepository;
import com.ogs.repository.LecturerRepository;
import com.ogs.repository.StudentRepository;

@Service
public class AdminServiceImpl implements AdminService {


	@Autowired
	private StudentRepository studentRepository;
	
    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private CourseRepository courseRepository;

	@Override
	public List<Student> viewAllStudents() {
	    return studentRepository.findAll();
	}

	@Override
	public boolean addStudent(Student student) {
	    if (studentRepository.existsById(student.getStudentId()) ||
	        studentRepository.findAll().stream().anyMatch(s -> s.getEmail().equals(student.getEmail()))) {
	        return false;
	    }
	    studentRepository.save(student);
	    return true;
	}

	@Override
	public boolean deleteStudent(Long studentId) {
	    if (studentRepository.existsById(studentId)) {
	        studentRepository.deleteById(studentId);
	        return true;
	    }
	    return false;
	}

	@Override
	public boolean updateStudent(Student student) {
	    if (studentRepository.existsById(student.getStudentId())) {
	        studentRepository.save(student);
	        return true;
	    }
	    return false;
	}

	@Override
	public boolean resetStudentPassword(Long studentId, String newPassword) {
	    Optional<Student> studentOptional = studentRepository.findById(studentId);
	    if (studentOptional.isPresent()) {
	        Student student = studentOptional.get();
	        student.setPassword(newPassword);
	        studentRepository.save(student);
	        return true;
	    }
	    return false;
	}

	@Override
	public List<Student> searchStudentsByCourse(String courseName) {
	    return studentRepository.findStudentsByCourseName(courseName);
	}

	@Override
	public List<Student> searchStudentsByName(String name) {
	    return studentRepository.findStudentsByName(name);
	}

	@Override
	public List<Student> filterStudentsByDepartmentId(Long departmentId) {
	    return studentRepository.findStudentsByDepartmentId(departmentId.toString());
	}

	@Override
	public List<Student> filterStudentsBySpecialization(String specialization) {
	    return studentRepository.findStudentsBySpecialization(specialization);
	}

	@Override
	public List<Course> viewEnrolledCoursesByStudent(Long studentId) {
	    return studentRepository.findCoursesByStudentId(studentId);
	}

	@Override
	public long studentCount() {
	    return studentRepository.count();
	}

	
	
	
	
	//-----------------------------------------------------------------------------------------------------------//


	@Override
	public List<Lecturer> viewAllLecturers() {
	    return lecturerRepository.findAll();
	}

	@Override
	public boolean addLecturer(Lecturer lecturer) {
	    if (lecturerRepository.existsById(lecturer.getLecturerUserId()) ||
	        lecturerRepository.findAll().stream().anyMatch(l -> l.getEmail().equals(lecturer.getEmail()))) {
	        return false;
	    }
	    lecturerRepository.save(lecturer);
	    return true;
	}

	@Override
	public boolean deleteLecturer(Integer lecturerId) {
	    if (lecturerRepository.existsById(lecturerId)) {
	        lecturerRepository.deleteById(lecturerId);
	        return true;
	    }
	    return false;
	}

	@Override
	public boolean updateLecturer(Lecturer lecturer) {
	    if (lecturerRepository.existsById(lecturer.getLecturerUserId())) {
	        lecturerRepository.save(lecturer);
	        return true;
	    }
	    return false;
	}

	@Override
	public List<Lecturer> searchLecturersByName(String name) {
	    return lecturerRepository.findByLecturerNameContainingIgnoreCase(name);
	}

	@Override
	public List<Lecturer> filterLecturersByDepartmentId(Long departmentId) {
	    return lecturerRepository.findByDeptId(departmentId.toString());
	}

	@Override
	public long lecturerCount() {
	    return lecturerRepository.count();
	}

	@Override
	public List<Course> viewAllCourses() {
	    return courseRepository.findAll();
	}

	@Override
	public boolean addCourse(Course course) {
	    if (courseRepository.existsById(course.getCourseId())) {
	        return false;
	    }
	    courseRepository.save(course);
	    return true;
	}

	@Override
	public boolean deleteCourse(String courseId) {
	    if (courseRepository.existsById(courseId)) {
	        courseRepository.deleteById(courseId);
	        return true;
	    }
	    return false;
	}

	@Override
	public boolean updateCourse(Course course) {
	    if (courseRepository.existsById(course.getCourseId())) {
	        courseRepository.save(course);
	        return true;
	    }
	    return false;
	}

	@Override
	public List<Course> searchCoursesByName(String name) {
	    return courseRepository.findByCourseNameContainingIgnoreCase(name);
	}

	@Override
	public List<Course> filterCoursesByDepartmentId(Long departmentId) {
	    return courseRepository.findByDepartmentId(departmentId.toString());
	}

	@Override
	public long courseCount() {
	    return courseRepository.count();
	}
	



	@Override
	public List<Course> viewCoursesByLecturer(Long lecturerId) {
	    return courseRepository.findByLecturerId(lecturerId);
	}


	@Override
	public boolean assignCourseToStudent(String courseId, Long studentId) {
	    // Check if the student and course exist in the database
	    if (studentRepository.existsById(studentId) && courseRepository.existsById(courseId)) {
	        // Use a custom query in the repository to link the course to the student
	        studentRepository.addCourseToStudent(courseId, studentId);
	        return true;
	    }
	    return false;
	}



	@Override
	public boolean updateStudentCourseEnrollment(Long studentId, List<String> courseIds) {
	    // Check if the student exists in the database
	    if (studentRepository.existsById(studentId)) {
	        // Use a custom repository method to clear and reassign the courses for the student
	        studentRepository.updateStudentCourses(studentId, courseIds);
	        return true;
	    }
	    return false;
	}


	@Override
	public List<Student> viewStudentsByCourse(String courseId) {
	    return studentRepository.findByCoursesCourseId(courseId);
	}

	
	@Override
	public Admin checkAdminLogin(String uname, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

}
