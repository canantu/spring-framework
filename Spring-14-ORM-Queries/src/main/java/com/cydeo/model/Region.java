package com.cydeo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "regions")
@NoArgsConstructor
@Data
public class Region {

    @Id
    private Long id;

    private String region;
    private String country;

    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
    private List<Employee> employee;

}
