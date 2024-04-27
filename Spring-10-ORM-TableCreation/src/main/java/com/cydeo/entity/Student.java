package com.cydeo.entity;

import com.cydeo.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "studentFirtName", length = 100)
    private String firstName;
    @Column(name = "studentLastName")
    private String lastName;
    private String email;

    @Transient
    private String city;

    @Column(columnDefinition = "DATE")
    private LocalDate birthday;
    @Column(columnDefinition = "TIME")
    private LocalTime birthTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate birthDateTime;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
