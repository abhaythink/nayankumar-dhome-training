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
        return repository.save(student);
    }

    public Mono<Student> updateStudent(int id, Student student) {
        return repository.findById(student.getId())
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
