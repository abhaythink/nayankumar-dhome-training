package com.nayankumar.demos.reactiveprogramming.crud.App.controller;

import com.nayankumar.demos.reactiveprogramming.crud.App.entity.Student;
import com.nayankumar.demos.reactiveprogramming.crud.App.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private StudentService service;

    @GetMapping
    public Flux<Student> getStudents() {
        return service.getStudents();
    }

    @GetMapping("/{id}")
    public Mono<Student> getUser(@PathVariable int id) {
        return service.getStudent(id);
    }

    @PostMapping("/create")
    public Mono<Student> createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @PutMapping("/update/{id}")
    public Mono<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }
}
