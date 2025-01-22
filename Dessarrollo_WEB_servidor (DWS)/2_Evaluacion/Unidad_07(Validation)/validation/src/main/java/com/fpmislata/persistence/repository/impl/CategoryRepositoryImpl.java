package com.fpmislata.persistence.repository.impl;

import com.fpmislata.domain.entity.Category;
import com.fpmislata.domain.repository.CategoryRepository;
import com.fpmislata.persistence.dao.CategoryDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryDao categoryDao;

    @Override
    public Optional<Category> findById(long id) {
        return categoryDao.findById(id);
    }
}
