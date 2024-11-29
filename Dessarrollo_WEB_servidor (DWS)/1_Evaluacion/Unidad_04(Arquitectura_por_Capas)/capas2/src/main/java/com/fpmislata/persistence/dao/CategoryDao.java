package com.fpmislata.persistence.dao;

import com.fpmislata.domain.entity.Category;

import java.util.Optional;

public interface CategoryDao {
    Optional<Category> findById(long id);
}
