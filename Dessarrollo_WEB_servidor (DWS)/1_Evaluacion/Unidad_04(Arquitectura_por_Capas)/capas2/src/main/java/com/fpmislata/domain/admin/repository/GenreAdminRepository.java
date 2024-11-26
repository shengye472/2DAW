package com.fpmislata.domain.admin.repository;

import com.fpmislata.domain.admin.entity.Genre;

import java.util.List;

public interface GenreAdminRepository {
    List<Genre> getByIsbnBook(String isbn);

    List<Genre> getByIdBook(long id);

    List<Genre> findAllById(Long[] ids);
}
