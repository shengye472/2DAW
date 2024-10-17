package com.fpmislata.persistence.repository.impl.mapper;

import com.fpmislata.common.locale.LanguageUtils;
import com.fpmislata.domain.entity.Book;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements CustomRowMapper<Book> {

    private final CategoryRowMapper categoryRowMapper = new CategoryRowMapper();
    private final PublisherRowMapper publisherRowMapper = new PublisherRowMapper();

    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        String language = LanguageUtils.getCurrentLanguage();
        Book book = new Book();
        book.setIsbn(rs.getString("books.isbn"));
        book.setTitle(rs.getString("books.title_" + language));
        book.setSynopsis(rs.getString("books.synopsis_" + language));
        book.setPrice(new BigDecimal(rs.getString("books.price")));
        book.setDiscount(rs.getFloat("books.discount"));
        book.setCover(rs.getString("books.cover"));
        if(this.existsColumn(rs, "publishers.id")) {
            book.setPublisher(publisherRowMapper.mapRow(rs, rowNum));
        }
        if(this.existsColumn(rs, "categories.id")) {
            book.setCategory(categoryRowMapper.mapRow(rs, rowNum));
        }
        return book;
    }

}
