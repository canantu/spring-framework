package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Location extends BaseEntity{

    private String name;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String postalCode;
    private String country;
    private String state;
    private String city;
    private String address;

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
