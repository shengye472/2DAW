package com.fpmislata.exam.persistance.dao;

import com.fpmislata.exam.domain.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll();
}
