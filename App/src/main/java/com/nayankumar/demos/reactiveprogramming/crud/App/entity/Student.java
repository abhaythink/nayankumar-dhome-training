package com.nayankumar.demos.reactiveprogramming.crud.App.entity;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private Integer id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Email format should be 'username@gamil.com'")
    private String email;

    @DecimalMin(value = "0.0", message = "percentage must be >=0")
    @DecimalMax(value = "100.00", message = "percentage must be <=100")
    private Double percentage;
}