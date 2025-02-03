package com.fpmislata.exam.persistance.dao.jpa;

import com.fpmislata.exam.domain.model.Book;
import com.fpmislata.exam.persistance.dao.BookDao;
import com.fpmislata.exam.persistance.dao.jpa.mapper.BookEntityMapper;
import com.fpmislata.exam.persistance.dao.jpa.repository.BookRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookDaoImpl implements BookDao {

    private final BookRepositoryJpa bookRepositoryJpa;

    @Override
    public List<Book> findAll() {
        return bookRepositoryJpa
                .findAll()
                .stream()
                .map(BookEntityMapper.INSTANCE::toBook)
                .toList();
    }
}
