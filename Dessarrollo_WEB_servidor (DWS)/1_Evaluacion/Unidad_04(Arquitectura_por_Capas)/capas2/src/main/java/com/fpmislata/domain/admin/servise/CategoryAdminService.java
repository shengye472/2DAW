package com.fpmislata.domain.admin.servise;

import com.fpmislata.domain.admin.entity.Category;

import java.util.Optional;

public interface CategoryAdminService {
    Optional<Category> findById(long id);
}
