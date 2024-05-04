package com.cydeo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user_account")
@Data
@NoArgsConstructor
public class User extends BaseEntity{

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_details_id" )
    private Account account;

    @OneToMany(mappedBy = "userAccount")
    private List<Ticket> ticket;

    private String email;
    private String password;
    private String username;
}
