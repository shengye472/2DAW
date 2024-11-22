package com.fpmislata.domain.admin.servise;

import com.fpmislata.domain.entity.Genre;

import java.util.List;

public interface GenreAdminService {
    List<Genre> findAllById(List<Genre> genres);
}
