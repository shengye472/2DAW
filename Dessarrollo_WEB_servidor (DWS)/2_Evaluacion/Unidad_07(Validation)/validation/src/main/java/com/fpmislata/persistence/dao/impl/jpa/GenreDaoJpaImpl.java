package com.fpmislata.persistence.dao.impl.jpa;

import com.fpmislata.domain.entity.Genre;
import com.fpmislata.persistence.dao.GenreDao;
import com.fpmislata.persistence.dao.impl.jpa.mapper.GenreJpaMapper;
import com.fpmislata.persistence.dao.impl.jpa.repository.GenreJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Primary
@RequiredArgsConstructor
@Component
public class GenreDaoJpaImpl implements GenreDao {

    private final GenreJpaRepository genreJpaRepository;

    @Override
    public List<Genre> getByIsbnBook(String isbn) {
        return genreJpaRepository
                .findByIsbn(isbn)
                .stream()
                .map(GenreJpaMapper.INSTANCE::toGenre)
                .toList();
    }

    @Override
    public List<Genre> getByIdBook(long id) {
        return genreJpaRepository
                .findByIdBook(id)
                .stream()
                .map(GenreJpaMapper.INSTANCE::toGenre)
                .toList();
    }

    @Override
    public List<Genre> findAllById(Long[] ids) {
        return genreJpaRepository
                .findAllById(List.of(ids))
                .stream()
                .map(GenreJpaMapper.INSTANCE::toGenre)
                .toList();
    }
}
