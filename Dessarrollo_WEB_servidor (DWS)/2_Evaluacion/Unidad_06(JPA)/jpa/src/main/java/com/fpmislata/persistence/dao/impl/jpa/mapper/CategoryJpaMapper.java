package com.fpmislata.persistence.dao.impl.jpa.mapper;

import com.fpmislata.domain.entity.Category;
import com.fpmislata.persistence.dao.impl.jpa.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryJpaMapper {

    CategoryJpaMapper INSTANCE = Mappers.getMapper(CategoryJpaMapper.class);

    Category toCategory(CategoryEntity categoryEntity);

}
