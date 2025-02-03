package com.fpmislata.exam.controller.webModel.mapper;

import com.fpmislata.exam.controller.webModel.BookCollection;
import com.fpmislata.exam.domain.model.Book;

public class Mapper {
    public static final Mapper INSTANCE = new Mapper();
    public BookCollection toBookCollection(Book book) {
        return new BookCollection(
                book.getIsbn(),
                book.getTitle()
        );
    }
}
