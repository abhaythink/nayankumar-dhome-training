package com.nayankumar.demos.reactiveprogramming.crud.App.repository;

import com.nayankumar.demos.reactiveprogramming.crud.App.entity.Student;
import jakarta.validation.constraints.Email;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentRepository extends ReactiveCrudRepository<Student, Integer> {
    Mono<Boolean> existsByEmail(@Email(message = "Email format should be like 'username@gamil.com'") String email);
}