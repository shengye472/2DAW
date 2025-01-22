package com.fpmislata.persistence.dao.impl.jpa.mapper;

import com.fpmislata.domain.entity.Author;
import com.fpmislata.persistence.dao.impl.jpa.entity.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorJpaMapper {

    AuthorJpaMapper INSTANCE = Mappers.getMapper(AuthorJpaMapper.class);

    Author toAuthor(AuthorEntity authorEntity);
}
