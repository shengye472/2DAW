package com.fpmislata.domain.repository;

import com.fpmislata.domain.entity.Category;

import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> findById(long id);
}
