package com.fpmislata.domain.admin.repository;

import com.fpmislata.domain.entity.Category;

import java.util.Optional;

public interface CategoryAdminRepository {
    Optional<Category> findById(long id);
}
