package com.develop.LibraryApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 32, nullable = false)
    private String firstName;

    @Column(length = 32, nullable = false)
    private String lastName;

    @Column(length = 50, unique = true, nullable = false)
    private String email;

    @Column(length = 50, unique = true, nullable = false)
    private String address;

    @Column(length = 3)
    private String years;

    @Column(length = 13,  unique = true, nullable = false)
    private String identificationCode;

    @OneToMany(mappedBy = "student")
    private Set<Reservation> reservations;
}
