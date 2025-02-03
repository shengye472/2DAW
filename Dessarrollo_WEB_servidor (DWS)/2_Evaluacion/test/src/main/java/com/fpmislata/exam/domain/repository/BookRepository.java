package com.fpmislata.exam.domain.repository;

import com.fpmislata.exam.domain.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
}
