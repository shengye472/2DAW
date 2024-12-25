package com.fpmislata.persistence.dao;

import com.fpmislata.domain.entity.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> getByIsbnBook(String isbn);

    List<Genre> getByIdBook(long id);

    List<Genre> findAllById(Long[] ids);
}
