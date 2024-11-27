package com.fpmislata.domain.servise;

import com.fpmislata.domain.entity.Category;

import java.util.Optional;

public interface CategoryService {
    Optional<Category> findById(long id);
}
