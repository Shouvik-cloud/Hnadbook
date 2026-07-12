package com.shouvik;

import jakarta.validation.Valid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class App {

    @GetMapping("/")
    public String home() {
        return "Welcome to Spring Boot!";
    }

    @GetMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> student() {
        Student student = new Student(101, "Shouvik Mondal", "B.Tech AI");
        return ResponseEntity.ok(student);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        Student student = new Student(id, "Shouvik Mondal", "B.Tech AI");
        return ResponseEntity.ok(student);
    }

    @GetMapping("/search")
    public ResponseEntity<Student> searchStudent(@RequestParam int id,
                                                 @RequestParam String name) {
        Student student = new Student(id, name, "B.Tech AI");
        return ResponseEntity.ok(student);
    }

    @PostMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id,
                                                 @RequestBody Student student) {
        student.setId(id);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        return ResponseEntity.ok("Student with ID " + id + " deleted successfully!");
    }

    @GetMapping("/student/error/{id}")
    public ResponseEntity<Student> getStudentError(@PathVariable int id) {

        if (id != 101) {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }

        Student student = new Student(101, "Shouvik Mondal", "B.Tech AI");
        return ResponseEntity.ok(student);
    }

    @GetMapping("/header")
    public ResponseEntity<String> getHeader(
            @RequestHeader(value = "User-Agent", required = false) String userAgent) {

        if (userAgent == null) {
            userAgent = "Unknown";
        }

        return ResponseEntity.ok("User-Agent: " + userAgent);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}