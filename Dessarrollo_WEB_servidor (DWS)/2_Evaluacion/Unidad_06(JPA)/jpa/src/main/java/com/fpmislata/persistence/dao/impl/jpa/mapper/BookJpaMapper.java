package com.fpmislata.persistence.dao.impl.jpa.mapper;

import com.fpmislata.domain.entity.Book;
import com.fpmislata.persistence.dao.impl.jpa.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AuthorJpaMapper.class, CategoryJpaMapper.class, GenreJpaMapper.class, PublisherJpaMapper.class})
public interface BookJpaMapper {

    BookJpaMapper INSTANCE = Mappers.getMapper(BookJpaMapper.class);

    @Mapping(target = "authors", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "publisher", ignore = true)
    @Mapping(target = "category", ignore = true)
    Book toBook(BookEntity bookEntity);

    Book toBookDetail(BookEntity bookEntity);
}
