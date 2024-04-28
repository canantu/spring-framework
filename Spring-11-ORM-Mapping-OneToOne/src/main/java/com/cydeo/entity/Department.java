package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
public class Department extends BaseEntity{

    @Column(length = 100)
    private String department;
    @Column(length = 100)
    private String division;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
