package com.fpmislata.persistence.repository.impl;

import com.fpmislata.domain.entity.Author;
import com.fpmislata.domain.repository.AuthorRepository;
import com.fpmislata.persistence.dao.AuthorDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final AuthorDao authorDao;

    @Override
    public List<Author> getByIsbnBook(String isbn) {
        return authorDao.getByIsbnBook(isbn);
    }

    @Override
    public List<Author> getByIdBook(long id) {
        return authorDao.getByIdBook(id);
    }

    @Override
    public List<Author> findAllById(Long[] ids) {
        return authorDao.findAllById(ids);
    }
}
