package com.fpmislata.domain.servise.impl;

import com.fpmislata.common.annotation.DomainService;
import com.fpmislata.domain.entity.Genre;
import com.fpmislata.domain.repository.GenreRepository;
import com.fpmislata.domain.servise.GenreService;
import com.fpmislata.common.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public List<Genre> findAllById(List<Genre> genres) {
        List<Genre> genreList = genreRepository.findAllById(
                genres.stream()
                        .map(Genre::getId)
                        .toArray(Long[]::new)
        );
        if (genreList.size() != genres.size()) {
            throw new ResourceNotFoundException("Some authors were not found");
        }
        return genreList;
    }
}
