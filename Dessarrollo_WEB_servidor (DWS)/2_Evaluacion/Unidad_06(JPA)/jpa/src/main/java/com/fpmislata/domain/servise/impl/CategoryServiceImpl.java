package com.fpmislata.domain.servise.impl;

import com.fpmislata.common.annotation.DomainService;
import com.fpmislata.domain.entity.Category;
import com.fpmislata.domain.repository.CategoryRepository;
import com.fpmislata.domain.servise.CategoryService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Optional<Category> findById(long id) {
        return categoryRepository.findById(id);
    }
}
