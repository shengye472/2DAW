package com.fpmislata.exam.persistance.repository;

import com.fpmislata.exam.domain.model.Book;
import com.fpmislata.exam.domain.repository.BookRepository;
import com.fpmislata.exam.persistance.dao.BookDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookDao bookDao;

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }
}
