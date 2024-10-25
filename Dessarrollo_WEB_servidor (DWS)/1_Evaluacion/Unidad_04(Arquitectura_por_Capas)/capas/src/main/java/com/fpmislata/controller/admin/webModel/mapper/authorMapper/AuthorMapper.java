package com.fpmislata.controller.admin.webModel.mapper.authorMapper;

import com.fpmislata.controller.admin.webModel.entity.author.AuthorCollection;
import com.fpmislata.domain.admin.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
    AuthorCollection toAuthorCollection(Author author);
}
