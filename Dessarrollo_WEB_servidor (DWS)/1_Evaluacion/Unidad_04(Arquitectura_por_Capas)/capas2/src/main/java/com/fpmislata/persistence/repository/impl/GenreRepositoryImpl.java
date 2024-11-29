package com.fpmislata.persistence.repository.impl;

import com.fpmislata.domain.entity.Genre;
import com.fpmislata.domain.repository.GenreRepository;
import com.fpmislata.persistence.dao.GenreDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GenreRepositoryImpl implements GenreRepository {

    private final GenreDao genreDao;


    @Override
    public List<Genre> getByIsbnBook(String isbn) {
        return genreDao.getByIsbnBook(isbn);
    }

    @Override
    public List<Genre> getByIdBook(long id) {
        return genreDao.getByIdBook(id);
    }

    @Override
    public List<Genre> findAllById(Long[] ids) {
        return genreDao.findAllById(ids);
    }
}
