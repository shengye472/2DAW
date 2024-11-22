package com.fpmislata.domain.admin.servise.impl;

import com.fpmislata.common.annotation.DomainService;
import com.fpmislata.domain.entity.Category;
import com.fpmislata.domain.repository.CategoryRepository;
import com.fpmislata.domain.admin.servise.CategoryAdminService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class CategoryAdminServiceImpl implements CategoryAdminService {
    private final CategoryRepository categoryAdminRepository;

    @Override
    public Optional<Category> findById(long id) {
        return categoryAdminRepository.findById(id);
    }
}
