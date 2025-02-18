package com.fpmislata.exam.controller.webModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class GameCollection {
    private Integer id;
    private String gameCode;
    private String title;
    private String releaseYear;
    private String description;
}
