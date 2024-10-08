package com.fpmislata.controller.webModel.mapper.authorMapper;

import com.fpmislata.controller.webModel.entity.author.AuthorCollection;
import com.fpmislata.domain.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
    AuthorCollection toAuthorCollection(Author author);
}
