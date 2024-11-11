package com.fpmislata.domain.user.repository;

import com.fpmislata.domain.user.entity.Genre;

import java.util.List;

public interface GenreUserRepository {
    List<Genre> findByIsbn(String isbn);
}
