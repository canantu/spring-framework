package com.cydeo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Location extends BaseEntity{

    private String name;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String country;
    private String city;
    private String state;
    private String postalCode;
    private String address;

    @OneToMany(mappedBy = "location")
    private List<Cinema> cinema;
}
