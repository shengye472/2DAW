package com.fpmislata.exam.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Game {
    private Integer id;
    private String gameCode;
    private String title;
    private String releaseYear;
    private String description;
    private Director director;
    private List<CharacterGame> characterGames;
}
