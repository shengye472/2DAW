package com.fpmislata.domain.admin.servise.impl;

import com.fpmislata.common.annotation.DomainService;
import com.fpmislata.domain.admin.entity.Genre;
import com.fpmislata.domain.admin.repository.GenreAdminRepository;
import com.fpmislata.domain.admin.servise.GenreAdminService;
import com.fpmislata.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class GenreAdminServiceImpl implements GenreAdminService {

    private final GenreAdminRepository genreAdminRepository;

    @Override
    public List<Genre> findAllById(List<Genre> genres) {
        List<Genre> genreList = genreAdminRepository.findAllById(
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
