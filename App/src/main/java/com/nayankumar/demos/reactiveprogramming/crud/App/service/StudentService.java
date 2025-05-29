package com.nayankumar.demos.reactiveprogramming.crud.App.service;

import com.nayankumar.demos.reactiveprogramming.crud.App.entity.Student;
import com.nayankumar.demos.reactiveprogramming.crud.App.exception.ResourceAlreadyExistsException;
import com.nayankumar.demos.reactiveprogramming.crud.App.exception.ResourceNotFoundException;
import com.nayankumar.demos.reactiveprogramming.crud.App.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public Mono<ResponseEntity<Student>> getStudent(int id) {
        return repository.findById(id)
                .map(student -> ResponseEntity.ok(student))
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Student not found with id: " + id)));
    }

    public Mono<ResponseEntity<Flux<Student>>> getStudents() {
        Flux<Student> students = repository.findAll();
        return Mono.just(ResponseEntity.ok(students));
    }

    public Mono<ResponseEntity<Student>> createStudent(Student student) {
        return repository.existsByEmail(student.getEmail())
                .flatMap(exists -> {
                    if (exists) {
                        return Mono.error(new ResourceAlreadyExistsException(
                                "Student already exists with email: " + student.getEmail()));
                    } else {
                        return repository.save(student)
                                .map(savedStudent -> ResponseEntity
                                        .status(HttpStatus.CREATED)
                                        .body(savedStudent));
                    }
                });
    }

    public Mono<ResponseEntity<Student>> updateStudent(int id, Student student) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Student not found with id: " + id)))
                .flatMap(existing -> {
                    existing.setName(student.getName());
                    existing.setEmail(student.getEmail());
                    existing.setPercentage(student.getPercentage());
                    return repository.save(existing);
                })
                .map(updatedStudent -> ResponseEntity.ok(updatedStudent));
    }


    public Mono<ResponseEntity<String>> deleteStudent(int id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Student not found with id: " + id)))
                .flatMap(existing -> repository.deleteById(id)
                        .thenReturn(ResponseEntity.ok("Student with ID " + id + " deleted successfully")));
    }
}