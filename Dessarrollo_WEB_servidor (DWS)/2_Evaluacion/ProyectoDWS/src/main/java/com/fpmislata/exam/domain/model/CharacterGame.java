package com.fpmislata.exam.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CharacterGame {
    private Integer id;
    private String name;
    private String role;
    private String description;
}
