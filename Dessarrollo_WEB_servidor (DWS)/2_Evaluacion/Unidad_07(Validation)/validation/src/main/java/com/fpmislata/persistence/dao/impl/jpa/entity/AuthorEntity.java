package com.fpmislata.persistence.dao.impl.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "authors")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String nationality;
    @Column(name = "biography_es")
    private String biographyEs;
    @Column(name = "biography_en")
    private String biographyEn;
    @Column(name = "birth_year")
    private Integer birthYear;
    @Column(name = "death_year")
    private Integer deathYear;
}
