package com.fpmislata.persistence.admin.impl.mapper;

import com.fpmislata.domain.admin.entity.Book;
import com.fpmislata.persistence.common.CustomRowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements CustomRowMapper<Book> {

    private final PublisherRowMapper publisherRowMapper = new PublisherRowMapper();
    private final CategoryRowMapper categoryRowMapper = new CategoryRowMapper();

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getLong("books.id"));
        book.setIsbn(rs.getString("books.isbn"));
        book.setTitleEs(rs.getString("books.title_es"));
        book.setTitleEs(rs.getString("books.title_en"));
        book.setSynopsisEs(rs.getString("books.synopsis_es"));
        book.setSynopsisEs(rs.getString("books.synopsis_en"));
        book.setPrice(new BigDecimal(rs.getString("books.price")));
        book.setDiscount(rs.getFloat("books.discount"));
        book.setCover(rs.getString("books.cover"));
        if (this.existsColumn(rs, "publishers.id")){
            book.setPublisher(publisherRowMapper.mapRow(rs, rowNum));
        }
        if (this.existsColumn(rs, "categories.id")){
            book.setCategory(categoryRowMapper.mapRow(rs, rowNum));
        }
        return book;
    }
}
