package com.ogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;
import com.ogs.model.Student;
import com.ogs.model.Course;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s JOIN s.courses c WHERE c.courseName = :courseName")
    List<Student> findStudentsByCourseName(@Param("courseName") String courseName);

    @Query("SELECT s FROM Student s WHERE LOWER(s.studentName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Student> findStudentsByName(@Param("name") String name);

    @Query("SELECT s FROM Student s WHERE s.deptId = :departmentId")
    List<Student> findStudentsByDepartmentId(@Param("departmentId") String departmentId);

    @Query("SELECT s FROM Student s WHERE LOWER(s.specialization) = LOWER(:specialization)")
    List<Student> findStudentsBySpecialization(@Param("specialization") String specialization);

    @Query("SELECT c FROM Student s JOIN s.courses c WHERE s.studentId = :studentId")
    List<Course> findCoursesByStudentId(@Param("studentId") Long studentId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Student_Courses WHERE student_id = :studentId", nativeQuery = true)
    void clearStudentCourses(@Param("studentId") Long studentId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Student_Courses (student_id, course_id) VALUES (:studentId, :courseId)", nativeQuery = true)
    void addCourseToStudent(@Param("courseId") String courseId, @Param("studentId") Long studentId);

    List<Student> findByCoursesCourseId(String courseId);

    default void updateStudentCourses(Long studentId, List<String> courseIds) {
        clearStudentCourses(studentId);
        for (String courseId : courseIds) {
            addCourseToStudent(courseId, studentId);
        }
    }
}
