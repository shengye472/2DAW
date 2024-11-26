package com.fpmislata.domain.userCase.book;

import com.fpmislata.domain.entity.Genre;

import java.util.List;

public interface BookInsertGenreUseCase {
    void insertGenres(Integer id, List<Genre> genres);
}
