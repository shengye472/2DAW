package com.fpmislata.persistence.dao.impl.jpa.mapper;

import com.fpmislata.domain.entity.Genre;
import com.fpmislata.persistence.dao.impl.jpa.entity.GenreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreJpaMapper {

    GenreJpaMapper INSTANCE = Mappers.getMapper(GenreJpaMapper.class);

    Genre toGenre (GenreEntity genreEntity);
}
