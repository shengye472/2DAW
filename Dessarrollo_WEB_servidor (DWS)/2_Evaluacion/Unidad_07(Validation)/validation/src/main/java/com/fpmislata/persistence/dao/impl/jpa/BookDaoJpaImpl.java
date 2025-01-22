package com.fpmislata.persistence.dao.impl.jpa;

import com.fpmislata.domain.entity.Book;
import com.fpmislata.persistence.dao.BookDao;
import com.fpmislata.persistence.dao.impl.jpa.mapper.BookJpaMapper;
import com.fpmislata.persistence.dao.impl.jpa.repository.BookJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Primary
public class BookDaoJpaImpl implements BookDao {

    private final BookJpaRepository bookJpaRepository;

    @Override
    public List<Book> getAll() {
        return bookJpaRepository
                .findAll()
                .stream()
                .map(BookJpaMapper.INSTANCE::toBook)
                .toList();
    }

    @Override
    public List<Book> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookJpaRepository
                .findAll(pageable)
                .stream()
                .map(BookJpaMapper.INSTANCE::toBook)
                .toList();
    }

    @Override
    public int count() {
        return bookJpaRepository.findAll().size();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return Optional.ofNullable(bookJpaRepository
                .findByIsbn(isbn))
                .map(BookJpaMapper.INSTANCE::toBookDetail);
    }

    @Override
    public Optional<Book> findById(long id) {
        return bookJpaRepository
                .findById(id)
                .map(BookJpaMapper.INSTANCE::toBookDetail);
    }

    @Override
    public void save(Book book) {
        bookJpaRepository.save(BookJpaMapper.INSTANCE.toBookEntity(book));
    }

    @Override
    public void deleteById(Long id) {
        bookJpaRepository.deleteById(id);
    }
}
