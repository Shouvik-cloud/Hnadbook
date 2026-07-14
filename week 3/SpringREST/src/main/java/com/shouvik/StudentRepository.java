package com.shouvik;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByName(String name);

    List<Student> findByCourse(String course);

    @Query("SELECT s FROM Student s WHERE s.course = ?1")
    List<Student> getStudentsByCourse(String course);

    @Query(value = "SELECT * FROM student WHERE course = ?1", nativeQuery = true)
    List<Student> getStudentsByCourseNative(String course);

    Page<Student> findAll(Pageable pageable);
}