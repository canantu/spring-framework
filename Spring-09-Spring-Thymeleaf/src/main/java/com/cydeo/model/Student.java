package com.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    private String firstname;
    private String lastname;
    private Integer age;
    private String state;

}
