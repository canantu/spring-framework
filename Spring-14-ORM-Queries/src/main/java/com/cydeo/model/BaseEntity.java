package com.cydeo.model;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseEntity {
    @Id
    private Long id;
}
