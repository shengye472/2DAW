package com.fpmislata.domain.servise;

import com.fpmislata.domain.entity.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> findAllById(List<Genre> genres);
}
