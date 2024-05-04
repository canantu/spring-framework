package com.cydeo.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Genre extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "genreList")
    private List<Movie> movie;
}
