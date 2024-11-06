package com.fpmislata.persistence.admin.repository;

import com.fpmislata.domain.admin.entity.Genre;

import java.util.List;

public interface GenreAdminRepository {
    List<Genre> getByIsbnBook(String isbn);
}
