package com.cydeo.model;

import jakarta.persistence.*;

@Entity
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
