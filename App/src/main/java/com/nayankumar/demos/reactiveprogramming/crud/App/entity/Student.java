package com.nayankumar.demos.reactiveprogramming.crud.App.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "students")
public class Student {
    @Id
    private Integer id;
    private String name;
    private String email;
    private Double percentage;
}
