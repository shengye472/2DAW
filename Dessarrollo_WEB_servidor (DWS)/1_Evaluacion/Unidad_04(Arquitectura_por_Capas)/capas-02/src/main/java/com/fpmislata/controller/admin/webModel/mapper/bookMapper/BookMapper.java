package com.fpmislata.controller.admin.webModel.mapper.bookMapper;

import com.fpmislata.controller.admin.webModel.entity.book.BookCollection;
import com.fpmislata.domain.admin.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "title",source = "book.title")
    BookCollection toBookCollection(Book book);
}
