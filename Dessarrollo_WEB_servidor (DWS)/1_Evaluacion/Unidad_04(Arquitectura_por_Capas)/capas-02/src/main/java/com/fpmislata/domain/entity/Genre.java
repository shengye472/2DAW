package com.fpmislata.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Genre {
    private int id;
    private String name;
    private String slug;
}
