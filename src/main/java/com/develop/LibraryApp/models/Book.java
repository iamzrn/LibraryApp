package com.develop.LibraryApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String title;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date publicationDate;

    @Column(length = 300)
    private String description;

    @Column(length = 6, nullable = false)
    private Integer numberOfPages;

    @OneToMany(mappedBy = "book")
    private Set<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
