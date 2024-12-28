package com.fpmislata.persistence.dao.impl.jpa;

import com.fpmislata.domain.entity.Author;
import com.fpmislata.persistence.dao.AuthorDao;
import com.fpmislata.persistence.dao.impl.jpa.mapper.AuthorJpaMapper;
import com.fpmislata.persistence.dao.impl.jpa.repository.AuthorJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Primary
public class AuthorDaoJpaImpl implements AuthorDao {

    private final AuthorJpaRepository authorJpaRepository;

    @Override
    public List<Author> getByIsbnBook(String isbn) {
        return authorJpaRepository
                .findByIsbn(isbn)
                .stream()
                .map(AuthorJpaMapper.INSTANCE::toAuthor)
                .toList();
    }

    @Override
    public List<Author> getByIdBook(long id) {
        return authorJpaRepository
                .findByIdBook(id)
                .stream()
                .map(AuthorJpaMapper.INSTANCE::toAuthor)
                .toList();
    }

    @Override
    public List<Author> findAllById(Long[] ids) {
        return authorJpaRepository
                .findAllById(List.of(ids))
                .stream()
                .map(AuthorJpaMapper.INSTANCE::toAuthor)
                .toList();
    }
}
