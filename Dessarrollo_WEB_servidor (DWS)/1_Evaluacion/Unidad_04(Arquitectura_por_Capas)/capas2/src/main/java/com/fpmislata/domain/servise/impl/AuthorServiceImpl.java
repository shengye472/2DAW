package com.fpmislata.domain.admin.servise.impl;

import com.fpmislata.common.annotation.DomainService;
import com.fpmislata.domain.entity.Author;
import com.fpmislata.domain.repository.AuthorRepository;
import com.fpmislata.domain.admin.servise.AuthorAdminService;
import com.fpmislata.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class AuthorAdminServiceImpl implements AuthorAdminService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> findAllById(List<Author> authors) {
        List<Author> authorList = authorRepository.findAllById(
                authors.stream()
                        .map(Author::getId)
                        .toArray(Long[]::new)
        );
        if(authorList.size() != authors.size()) {
            throw new ResourceNotFoundException("Some authors were not found");
        }

        return authorList;
    }
}
