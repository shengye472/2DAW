package com.fpmislata.exam.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Director {
    private Integer id;
    private String name;
    private String biography;
}
