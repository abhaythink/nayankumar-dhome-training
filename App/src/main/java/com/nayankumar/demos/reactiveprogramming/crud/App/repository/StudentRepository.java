package com.nayankumar.demos.reactiveprogramming.crud.App.repository;

import com.nayankumar.demos.reactiveprogramming.crud.App.entity.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface StudentRepository extends ReactiveCrudRepository<Student, Integer> {
}
