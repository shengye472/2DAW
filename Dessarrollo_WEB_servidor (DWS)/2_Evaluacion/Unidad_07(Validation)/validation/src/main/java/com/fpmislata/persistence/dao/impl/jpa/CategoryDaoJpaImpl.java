package com.fpmislata.persistence.dao.impl.jpa;

import com.fpmislata.domain.entity.Category;
import com.fpmislata.persistence.dao.CategoryDao;
import com.fpmislata.persistence.dao.impl.jpa.mapper.CategoryJpaMapper;
import com.fpmislata.persistence.dao.impl.jpa.repository.CategoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Primary
@Component
@RequiredArgsConstructor
public class CategoryDaoJpaImpl implements CategoryDao {

    private final CategoryJpaRepository categoryJpaRepository;

    @Override
    public Optional<Category> findById(long id) {
        return categoryJpaRepository
                .findById(id)
                .map(CategoryJpaMapper.INSTANCE::toCategory);
    }
}
