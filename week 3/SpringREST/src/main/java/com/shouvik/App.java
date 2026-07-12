package com.shouvik;

import jakarta.validation.Valid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class App {

    @GetMapping("/")
    public String home() {
        return "Welcome to Spring Boot!";
    }

    @GetMapping("/student")
    public Student student() {
        return new Student(101, "Shouvik Mondal", "B.Tech AI");
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {
        return new Student(id, "Shouvik Mondal", "B.Tech AI");
    }

    @GetMapping("/search")
    public Student searchStudent(@RequestParam int id,
                                 @RequestParam String name) {
        return new Student(id, name, "B.Tech AI");
    }

    @PostMapping("/student")
    public Student addStudent(@Valid @RequestBody Student student) {
        return student;
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable int id,
                                 @RequestBody Student student) {
        student.setId(id);
        return student;
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id) {
        return "Student with ID " + id + " deleted successfully!";
    }

    @GetMapping("/student/error/{id}")
    public Student getStudentError(@PathVariable int id) {

        if (id != 101) {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }

        return new Student(101, "Shouvik Mondal", "B.Tech AI");
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}