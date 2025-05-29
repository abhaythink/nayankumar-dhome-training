package com.nayankumar.demos.reactiveprogramming.crud.App.controller;

import com.nayankumar.demos.reactiveprogramming.crud.App.entity.Student;
import com.nayankumar.demos.reactiveprogramming.crud.App.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private StudentService service;

    @GetMapping
    public Mono<ResponseEntity<Flux<Student>>> getStudents() {
        return service.getStudents();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Student>> getUser(@PathVariable int id) {
        return service.getStudent(id);
    }

    @PostMapping
    public Mono<ResponseEntity<Student>> createStudent(@Valid @RequestBody Student student) {
        return service.createStudent(student);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Student>> updateStudent(@PathVariable int id, @Valid @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("{id}")
    public Mono<ResponseEntity<String>> deleteStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }
}