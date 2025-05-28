package com.nayankumar.demos.reactiveprogramming.crud.App.service;

import com.nayankumar.demos.reactiveprogramming.crud.App.entity.Student;
import com.nayankumar.demos.reactiveprogramming.crud.App.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository repository;

    public Mono<Student> getStudent(int id) {
        return repository.findById(id);
    }

    public Flux<Student> getStudents() {
        return repository.findAll();
    }

    public Mono<Student> createStudent(Student student) {
        return Mono.just(student)
                .map(stud -> {
                    Student newStudent = new Student();
                    newStudent.setName(stud.getName());
                    newStudent.setPercentage(stud.getPercentage());
                    newStudent.setEmail(stud.getEmail());
                    return newStudent;
                })
                .flatMap(repository::save);
    }

    public Mono<Student> updateStudent(int id, Student student) {
        return repository.findById(id)
                .flatMap(existingStudent -> {
                    existingStudent.setName(student.getName());
                    existingStudent.setEmail(student.getEmail());
                    existingStudent.setPercentage(student.getPercentage());
                    return repository.save(existingStudent);
                });
    }

    public Mono<Void> deleteStudent(int id) {
        return repository.deleteById(id);
    }
}
