package com.fpmislata.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private int id;
    private String name;
    private String nationality;
    private String biography;
    private int birthYear;
    private int deathYear;
}
