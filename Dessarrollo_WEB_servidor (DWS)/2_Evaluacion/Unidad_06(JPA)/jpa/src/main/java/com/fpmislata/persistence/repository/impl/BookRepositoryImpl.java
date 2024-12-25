package com.fpmislata.persistence.repository.impl;

import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.repository.BookRepository;
import com.fpmislata.persistence.dao.BookDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookDao bookDao;

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public List<Book> getAll(int page, int size) {
        return bookDao.getAll(page, size);
    }

    @Override
    public int count() {
        return bookDao.count();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return bookDao.findByIsbn(isbn);
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookDao.findById(id);
    }

    @Override
    public void save(Book book) {
        bookDao.save(book);
    }
}
