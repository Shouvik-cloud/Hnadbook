package com.shouvik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class App {

    @Autowired
    private StudentRepository repository;

    @GetMapping("/")
    public String home() {
        return "Welcome to Spring Boot!";
    }

    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = repository.save(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @GetMapping("/student/page/{page}/{size}")
    public Page<Student> getStudentsByPage(@PathVariable int page,
                                           @PathVariable int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/student/sort/{field}")
    public List<Student> sortStudents(@PathVariable String field) {
        return repository.findAll(Sort.by(field));
    }

    @GetMapping("/student/name/{name}")
    public List<Student> getStudentByName(@PathVariable String name) {
        return repository.findByName(name);
    }

    @GetMapping("/student/course/{course}")
    public List<Student> getStudentByCourse(@PathVariable String course) {
        return repository.findByCourse(course);
    }

    @GetMapping("/student/query/{course}")
    public List<Student> getStudentsUsingQuery(@PathVariable String course) {
        return repository.getStudentsByCourse(course);
    }

    @GetMapping("/student/native/{course}")
    public List<Student> getStudentsUsingNativeQuery(@PathVariable String course) {
        return repository.getStudentsByCourseNative(course);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));

        return ResponseEntity.ok(student);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        student.setId(id);
        Student updatedStudent = repository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Student deleted successfully!");
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}