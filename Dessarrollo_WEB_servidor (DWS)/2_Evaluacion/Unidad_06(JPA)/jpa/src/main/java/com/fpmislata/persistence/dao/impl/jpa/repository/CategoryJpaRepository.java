package com.fpmislata.persistence.dao.impl.jpa.repository;

import com.fpmislata.persistence.dao.impl.jpa.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {

}
