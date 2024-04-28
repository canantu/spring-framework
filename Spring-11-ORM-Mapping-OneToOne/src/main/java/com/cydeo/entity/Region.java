package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "regions")
@Data
@NoArgsConstructor
public class Region extends BaseEntity{
    @Column(length = 20)
    private String region;
    @Column(length = 20)
    private String country;

    public Region(String region, String country) {
        this.region = region;
        this.country = country;
    }
}
