package com.cydeo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "departments")
@NoArgsConstructor
public class Department extends BaseEntity {

    private String department;
    private String division;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Employee> employee;

}
