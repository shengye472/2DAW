package com.fpmislata.persistence.repository;

import com.fpmislata.domain.entity.Genre;

import java.util.List;

public interface GenreRepository {
    List<Genre> findByIsbn(String isbn);
}
