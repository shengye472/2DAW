package com.fpmislata.exam.persistance.dao.jpa.mapper;

import com.fpmislata.exam.domain.model.Book;
import com.fpmislata.exam.persistance.dao.jpa.model.BookEntity;

public class BookEntityMapper {
    public static final BookEntityMapper INSTANCE = new BookEntityMapper();

    public Book toBook(BookEntity bookEntity) {
        Book book = new Book();
        book.setId(bookEntity.getId());
        book.setIsbn(bookEntity.getIsbn());
        book.setTitleEs(bookEntity.getTitleEs());
        book.setTitleEn(bookEntity.getTitleEn());
        book.setSynopsisEs(bookEntity.getSynopsisEs());
        book.setSynopsisEn(bookEntity.getSynopsisEn());
        book.setPrice(bookEntity.getPrice());
        book.setDiscount(bookEntity.getDiscount());
        book.setCover(bookEntity.getCover());
        return book;
    }
}
