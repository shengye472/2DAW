package com.fpmislata.domain.admin.userCase.book;

import com.fpmislata.domain.admin.entity.Genre;

import java.util.List;

public interface BookAdminInsertGenreUseCase {
    void insertGenres(Integer id, List<Genre> genres);
}
