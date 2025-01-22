package com.fpmislata.domain.servise;

import com.fpmislata.domain.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAllById(List<Author> authors);
}
