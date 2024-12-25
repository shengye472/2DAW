package com.fpmislata.domain.useCase.book.admin;

import com.fpmislata.domain.entity.Genre;

import java.util.List;

public interface BookInsertGenreUseCase {
    void insertGenres(Integer id, List<Genre> genres);
}
