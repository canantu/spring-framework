package com.cydeo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Ticket extends BaseEntity{

    private LocalDate dateTime;
    private Integer seatNumber;
    private Integer rowNumber;

    @ManyToOne
    private User userAccount;

    @ManyToOne
    private MovieCinema movieCinema;
}
