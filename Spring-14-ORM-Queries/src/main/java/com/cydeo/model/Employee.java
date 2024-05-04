package com.cydeo.model;

import com.cydeo.enums.Gender;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@NoArgsConstructor
public class Employee {

    @Id
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private BigDecimal salary;
    @ManyToOne
    private Region region;
    @ManyToOne
    private Department department;


}
