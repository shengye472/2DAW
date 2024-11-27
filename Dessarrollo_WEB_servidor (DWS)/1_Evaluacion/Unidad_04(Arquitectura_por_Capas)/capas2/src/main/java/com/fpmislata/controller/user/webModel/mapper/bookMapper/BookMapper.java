package com.fpmislata.controller.user.webModel.mapper.bookMapper;

import com.fpmislata.controller.user.webModel.entity.book.BookCollection;
import com.fpmislata.controller.user.webModel.entity.book.BookDetail;
import com.fpmislata.controller.user.webModel.mapper.authorMapper.AuthorMapper;
import com.fpmislata.controller.user.webModel.mapper.genreMapper.GenreMapper;
import com.fpmislata.controller.user.webModel.mapper.publisherMapper.PublisherMapper;
import com.fpmislata.domain.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {PublisherMapper.class, AuthorMapper.class, GenreMapper.class})
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookCollection toBookCollection(Book book);

    @Mapping(target = "publisherCollection",source = "publisher")
    @Mapping(target="authorsCollection", source = "authors")
    @Mapping(target = "category", source = "category.name")
    @Mapping(target = "genres", source = "genres")
    BookDetail toBookDetail(Book book);
}