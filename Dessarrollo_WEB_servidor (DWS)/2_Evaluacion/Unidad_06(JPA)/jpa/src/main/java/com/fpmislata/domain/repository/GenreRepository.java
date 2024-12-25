package com.fpmislata.domain.repository;

import com.fpmislata.domain.entity.Genre;

import java.util.List;

public interface GenreRepository {
    List<Genre> getByIsbnBook(String isbn);

    List<Genre> getByIdBook(long id);

    List<Genre> findAllById(Long[] ids);
}
