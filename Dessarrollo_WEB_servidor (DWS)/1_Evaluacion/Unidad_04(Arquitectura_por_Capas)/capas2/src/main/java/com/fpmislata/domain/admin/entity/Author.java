package com.fpmislata.domain.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private long id;
    private String name;
    private String nationality;
    private String biographyEs;
    private String BiographyEn;
    private int birthYear;
    private int deathYear;
}
